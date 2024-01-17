package service;

import base.service.BaseEntityService;
import entity.business.Address;
import entity.business.Order;
import entity.business.Wallet;
import entity.users.Customer;

public interface CustomerService extends BaseEntityService<Customer,Integer> {

    Customer signUp(Customer customer);

    void changePassword(String email, String oldPassword,String newPassword);

    Order createOrder(Order order, Integer category, Integer subDutyId, Address address,Integer customerId);

    Address createAddress(Address address,Integer customerId,Integer orderId);

}
