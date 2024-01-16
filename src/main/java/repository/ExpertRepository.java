package repository;

import base.repository.BaseEntityRepository;
import entity.business.Order;
import entity.users.Expert;

import java.util.List;

public interface ExpertRepository extends BaseEntityRepository<Expert,Integer> {

    void changePassword(String email, String oldPassword,String newPassword);

    List<Order> seeOrder(Integer expertId);
}
