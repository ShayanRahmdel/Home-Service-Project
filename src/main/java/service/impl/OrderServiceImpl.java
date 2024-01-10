package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.business.Comment;
import entity.business.Order;
import repository.CommentRepository;
import repository.OrderRepository;
import service.CommentService;
import service.OrderService;

public class OrderServiceImpl extends BaseEntityServiceImpl<Order,Integer, OrderRepository> implements OrderService {
    public OrderServiceImpl(OrderRepository repository) {
        super(repository);
    }
}
