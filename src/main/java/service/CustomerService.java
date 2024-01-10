package service;

import base.service.BaseEntityService;
import entity.users.Customer;

public interface CustomerService extends BaseEntityService<Customer,Integer> {

    Customer signUp(String firstName, String lastName, String email, String password);
}
