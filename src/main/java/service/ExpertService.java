package service;

import base.service.BaseEntityService;
import entity.business.Order;
import entity.users.Customer;
import entity.users.Expert;

import java.util.List;

public interface ExpertService extends BaseEntityService<Expert,Integer> {

    String signUp(Expert expert);

    List<Order> seeOrder(Integer expertId);

}
