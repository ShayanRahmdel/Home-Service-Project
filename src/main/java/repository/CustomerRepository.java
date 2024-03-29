package repository;

import base.repository.BaseEntityRepository;
import entity.users.Customer;

public interface CustomerRepository extends BaseEntityRepository<Customer,Integer> {

    void changePassword(String email, String oldPassword,String newPassword);
}
