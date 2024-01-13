package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.business.Order;
import repository.OrderRepository;

import javax.persistence.EntityManager;

public class OrderRepositoryImpl extends BaseEntityRepositoryImpl<Order,Integer> implements OrderRepository {
    public OrderRepositoryImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    @Override
    public Class<Order> getEntityClass() {
        return Order.class;
    }
}
