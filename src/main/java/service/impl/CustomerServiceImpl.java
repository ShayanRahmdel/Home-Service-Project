package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.users.Customer;
import repository.CustomerRepository;
import service.CustomerService;
import util.Validate;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class CustomerServiceImpl extends BaseEntityServiceImpl<Customer, Integer, CustomerRepository>
        implements CustomerService {
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }

    @Override
    public String signUp(Customer customer) {
        if (Validate.nameValidation(customer.getFirstName()) &&
                Validate.nameValidation(customer.getLastName()) &&
                Validate.emailValidation(customer.getEmail()) &&
                Validate.passwordValidation(customer.getPassword())) {
            repository.saveOrUpdate(customer);
            return "success";
        }
        return "your customer not save";
    }

    @Override
    public void changePassword(String email, String oldPassword, String newPassword) {
        repository.changePassword(email, oldPassword, newPassword);

    }
}

