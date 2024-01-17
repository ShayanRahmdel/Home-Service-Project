package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.users.Customer;
import repository.CustomerRepository;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class CustomerRepositoryImpl extends BaseEntityRepositoryImpl<Customer,Integer> implements CustomerRepository {
    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }

    @Override
    public void changePassword(String email, String oldPassword, String newPassword) {
        String hql = "UPDATE Customer c set c.password= :newPassword WHERE c.email= :email and c.password= :oldPassword";
        try {
            beginTransaction();
            Query query = entityManager.createQuery(hql);
            query.setParameter("newPassword",newPassword);
            query.setParameter("oldPassword",oldPassword);
            query.setParameter("email",email);
            query.executeUpdate();
            commitTransaction();
        }catch (IllegalArgumentException e){
            System.out.println("something went wrong");
            rollBack();
        }

    }
}
