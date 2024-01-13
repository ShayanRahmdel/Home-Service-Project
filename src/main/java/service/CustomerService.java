package service;

import base.service.BaseEntityService;
import entity.business.Wallet;
import entity.users.Customer;

public interface CustomerService extends BaseEntityService<Customer,Integer> {

    String signUp(Customer customer);

    void changePassword(String email, String oldPassword,String newPassword);


}
