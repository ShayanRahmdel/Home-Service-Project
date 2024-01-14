package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.business.DutyCategory;
import entity.business.SubDuty;
import entity.users.Admin;
import entity.users.Customer;
import entity.users.Expert;
import repository.AdminRepository;
import service.*;

import javax.persistence.PersistenceException;
import java.util.Collection;
import java.util.List;

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
        }catch (PersistenceException e){
            System.out.println("you already have this DutyCategory");
        }

    return dutyCategory;
    }

    @Override
    public SubDuty createSubDuty(SubDuty subDuty,Integer category) {
        seeAllDutyCategories();
        try {
            DutyCategory dutyCategory = new DutyCategory(category);
            subDuty.setDutyCategory(dutyCategory);
            subDutyService.saveOrUpdate(subDuty);
        }catch (PersistenceException e){
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
        if (allDutyCategory.size()==0){
            System.out.println("No duty category");
        }
        return allDutyCategory.stream().toList();
    }

    @Override
    public List<SubDuty> seeAllSubDuty() {
        Collection<SubDuty> allSubDuty = subDutyService.findAll();
        if (allSubDuty.size()==0){
            System.out.println("No Subduty");
        }
        return allSubDuty.stream().toList();
    }

    @Override
    public void addExpertInSubDuty(Expert expert) {

    }
}
