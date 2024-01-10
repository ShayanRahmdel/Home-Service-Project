package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.business.Comment;
import entity.users.Customer;
import repository.CommentRepository;
import repository.CustomerRepository;
import service.CommentService;
import service.CustomerService;

public class CustomerServiceImpl extends BaseEntityServiceImpl<Customer,Integer, CustomerRepository>
        implements CustomerService {
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }

    @Override
    public Customer signUp(String firstName, String lastName, String email, String password) {
        Customer customer = new Customer(firstName, lastName, email, password);

    }
}
