package service;

import base.service.BaseEntityService;
import entity.business.DutyCategory;
import entity.users.Admin;
import entity.users.Customer;

import java.util.List;

public interface AdminService extends BaseEntityService<Admin,Integer> {

    String createDutyCategory(DutyCategory dutyCategory);

    List<Customer> seeAllCustomer();
}
