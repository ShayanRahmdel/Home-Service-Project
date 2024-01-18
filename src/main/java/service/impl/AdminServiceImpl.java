package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.business.DutyCategory;
import entity.business.SubDuty;
import entity.enumration.Confirmation;
import entity.users.Admin;
import entity.users.Customer;
import entity.users.Expert;
import repository.AdminRepository;
import service.*;

import javax.persistence.PersistenceException;
import java.util.*;

public class AdminServiceImpl extends BaseEntityServiceImpl<Admin, Integer, AdminRepository>
        implements AdminService {

    private final CustomerService customerService;
    private final ExpertService expertService;
    private final DutyCategoryService dutyCategoryService;
    private final SubDutyService subDutyService;

    public AdminServiceImpl(AdminRepository adminRepository, ExpertService expertService, CustomerService customerService, DutyCategoryService dutyCategoryService, SubDutyService subDutyService) {
        super(adminRepository);
        this.expertService = expertService;
        this.customerService = customerService;
        this.dutyCategoryService = dutyCategoryService;
        this.subDutyService = subDutyService;
    }

    @Override
    public DutyCategory createDutyCategory(DutyCategory dutyCategory) {
        try {

            Collection<DutyCategory> all = dutyCategoryService.findAll();
            for (DutyCategory dutyCategoris : all) {
                if (dutyCategoris.getTitle().equals(dutyCategory.getTitle())){
                    throw new PersistenceException("duplicate duty category title");
                }
            }
            if (dutyCategory.getTitle().equals("")){
                throw  new PersistenceException("Empty title");
            }
            dutyCategoryService.saveOrUpdate(dutyCategory);
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        }

        return dutyCategory;
    }

    @Override
    public SubDuty createSubDuty(SubDuty subDuty, Integer category) {

        try {
            System.out.println(seeAllDutyCategories());
            Collection<SubDuty> all = subDutyService.findAll();
            for (SubDuty sub : all) {
                String description = sub.getDescription();
                if (subDuty.getDescription().equals(description)){
                    throw new PersistenceException("Duplicate description");
                }
            }
            DutyCategory dutyCategory = dutyCategoryService.findById(category).orElseThrow(PersistenceException::new);
            subDuty.setDutyCategory(dutyCategory);
            if (subDuty.getDescription().equals("")){
                throw  new PersistenceException("Empty description");
            }
            subDutyService.saveOrUpdate(subDuty);
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        }

        return subDuty;
    }

    @Override
    public List<Customer> seeAllCustomer() {
        Collection<Customer> allCustomer = customerService.findAll();
        return allCustomer.stream().toList();
    }

    @Override
    public List<Expert> seeAllExpert() {
        Collection<Expert> allExpert = expertService.findAll();
        return allExpert.stream().toList();
    }

    @Override
    public List<DutyCategory> seeAllDutyCategories() {

        Collection<DutyCategory> allDutyCategory = dutyCategoryService.findAll();
        if (allDutyCategory.size() == 0) {
            System.out.println("No duty category");
        }
        return allDutyCategory.stream().toList();
    }

    @Override
    public List<SubDuty> seeAllSubDuty() {
        Collection<SubDuty> allSubDuty = subDutyService.findAll();
        if (allSubDuty.size() == 0) {
            System.out.println("No Subduty");
        }
        return allSubDuty.stream().toList();
    }

    @Override
    public void addExpertInSubDuty(Integer expertId, Integer subDutyId) {
        List<Expert> experts1 = seeAllExpert();
        System.out.println(experts1);
        List<SubDuty> subDuties = seeAllSubDuty();
        System.out.println(subDuties);

        Expert expert = expertService.findById(expertId).orElse(null);
        SubDuty subDuty = subDutyService.findById(subDutyId).orElse(null);

        if (expert != null && subDuty != null && expert.getConfirmation().equals(Confirmation.Accepted) && validateExpertOneDutyCategory(expert,subDutyId)) {

            expert.getSubDuties().add(subDuty);
            subDuty.getExperts().add(expert);

            expertService.saveOrUpdate(expert);
            subDutyService.saveOrUpdate(subDuty);
        } else {
            System.out.println("Cannot add this Expert to subDuty.");
        }
    }

    @Override
    public void confirmExpert(Integer expertId) {
        try {
            Expert expert = expertService.findById(expertId).orElseThrow(()->new IllegalArgumentException("Cannot find id"));
            assert expert != null;
            expert.setConfirmation(Confirmation.Accepted);
            expertService.saveOrUpdate(expert);
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }

    @Override
    public void removeExpertFromSubDuty(Integer expertId, Integer subDutyId) {
        Optional<Expert> optionalExpert = expertService.findById(expertId);
        Optional<SubDuty> optionalSubDuty = subDutyService.findById(subDutyId);

        if (optionalExpert.isPresent() && optionalSubDuty.isPresent()) {
            Expert expert = optionalExpert.get();
            SubDuty subDuty = optionalSubDuty.get();

            expert.getSubDuties().remove(subDuty);
            subDuty.getExperts().remove(expert);

            expertService.saveOrUpdate(expert);
            subDutyService.saveOrUpdate(subDuty);
        }

    }

    @Override
    public boolean validateExpertOneDutyCategory(Expert expert,Integer newDutyCategory) {
        Set<SubDuty> subDuties = expert.getSubDuties();
        SubDuty subDuty = subDutyService.findById(newDutyCategory).orElse(null);
        assert subDuty != null;
        Integer id = subDuty.getDutyCategory().getId();
        for (SubDuty expertsubDuty : subDuties) {
            Integer expertid = expertsubDuty.getDutyCategory().getId();
            if (!Objects.equals(expertid, id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void removeDutyCategory(Integer dutyCategoryId) {
        List<DutyCategory> dutyCategories = seeAllDutyCategories();
        System.out.println(dutyCategories);
        try {
            dutyCategoryService.deleteById(dutyCategoryId);
        }catch (IllegalArgumentException e){
            System.out.println("Unable to delete");
        }

    }

    @Override
    public void removeSubDuty(Integer subDutyId) {
        List<SubDuty> subDuties = seeAllSubDuty();
        System.out.println(subDuties);
        try {
            subDutyService.deleteById(subDutyId);
        }catch (IllegalArgumentException e){
            System.out.println("Unable to delete");
        }

    }

    @Override
    public void removeCustomer(Integer customerId) {
        List<Customer> customers = seeAllCustomer();
        System.out.println(customers);
        try {
            customerService.deleteById(customerId);
        }catch (IllegalArgumentException e){
            System.out.println("Unable to delete");
        }

    }

    @Override
    public void removeExpert(Integer expertId) {
        List<Expert> experts = seeAllExpert();
        System.out.println(experts);
        try {
            expertService.deleteById(expertId);
        }catch (IllegalArgumentException e){
            System.out.println("Unable to delete");
        }

    }

    @Override
    public void updateSubDuty(Integer subDutyId, String newDescription, Double newBasePrice) {
        try{
            SubDuty subDuty = subDutyService.findById(subDutyId).orElse(null);
            assert subDuty != null;
            if (newDescription.equals("")|| newBasePrice<=0){
                throw new IllegalArgumentException();
            }
            subDuty.setDescription(newDescription);
            subDuty.setBasePrice(newBasePrice);
            subDutyService.saveOrUpdate(subDuty);
        }catch (IllegalArgumentException e){
            System.out.println("Error updating");
        }


    }

    @Override
    public List<SubDuty> seeSubDutyByCategory(Integer category) {

        List<SubDuty> subDuties = subDutyService.seeSubDutyByCategory(category);
        if (subDuties.size() == 0) {
            System.out.println("no SubDuty found for category ");
        }
        return subDuties;
    }


    @Override
    public void deleteDutyCategory(Integer dutyCategoryId) {
        try {
            dutyCategoryService.deleteById(dutyCategoryId);
        }catch (IllegalArgumentException e){
            System.out.println("Error: check dutyCategory id");
        }

    }

    @Override
    public void deleteSubDuty(Integer subDutyId) {
        try {
            subDutyService.deleteById(subDutyId);
        }catch (IllegalArgumentException e){
            System.out.println("Error: check SubDuty id");
        }

    }

    @Override
    public void updateDutyCategory(Integer dutyCategoryId,String newTitle) {
        try {
            DutyCategory dutyCategory = dutyCategoryService.findById(dutyCategoryId).orElse(null);
            assert dutyCategory != null;
            dutyCategory.setTitle(newTitle);
            if (newTitle.equals("")){
                throw new IllegalArgumentException();
            }
            dutyCategoryService.saveOrUpdate(dutyCategory);
        }catch (IllegalArgumentException e){
            System.out.println("Error: check dutyCategory ");
        }
    }
}
