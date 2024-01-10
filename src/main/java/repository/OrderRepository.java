package repository;

import base.repository.BaseEntityRepository;
import entity.business.Order;
import entity.users.Customer;

public interface OrderRepository extends BaseEntityRepository<Order,Integer> {
}
