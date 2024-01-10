package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.users.Customer;
import repository.CustomerRepository;

import javax.persistence.EntityManager;

public class CustomerRepositoryImpl extends BaseEntityRepositoryImpl<Customer,Integer> implements CustomerRepository {
    public CustomerRepositoryImpl(EntityManager entityManager) {
        super();
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
