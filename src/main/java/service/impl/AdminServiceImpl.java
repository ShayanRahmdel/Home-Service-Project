package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.business.DutyCategory;
import entity.users.Admin;
import entity.users.Customer;
import repository.AdminRepository;
import service.*;

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
    public String createDutyCategory(DutyCategory dutyCategory) {
        return null;
    }

    @Override
    public List<Customer> seeAllCustomer() {
        Collection<Customer> allCustomer = customerService.findAll();
        return allCustomer.stream().toList();
    }
}
