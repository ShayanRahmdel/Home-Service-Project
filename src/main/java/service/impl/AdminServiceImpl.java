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
            dutyCategoryService.saveOrUpdate(dutyCategory);
        } catch (PersistenceException e) {
            System.out.println("you already have this DutyCategory");
        }

        return dutyCategory;
    }

    @Override
    public SubDuty createSubDuty(SubDuty subDuty, Integer category) {
        seeAllDutyCategories();
        try {
            DutyCategory dutyCategory = new DutyCategory(category);
            subDuty.setDutyCategory(dutyCategory);
            subDutyService.saveOrUpdate(subDuty);
        } catch (PersistenceException e) {
            System.out.println("you already have this SubCategory");
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
        Expert expert = expertService.findById(expertId).orElse(null);
        assert expert != null;
        expert.setConfirmation(Confirmation.Accepted);
        expertService.saveOrUpdate(expert);
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
}
