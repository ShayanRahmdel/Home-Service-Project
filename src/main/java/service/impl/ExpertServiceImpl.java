package service.impl;

import base.entity.BaseEntity;
import base.service.impl.BaseEntityServiceImpl;
import entity.business.Comment;
import entity.business.Order;
import entity.business.SubDuty;
import entity.enumration.Confirmation;
import entity.enumration.OrderStatus;
import entity.enumration.TypeUser;
import entity.users.Expert;
import repository.CommentRepository;
import repository.ExpertRepository;
import service.CommentService;
import service.ExpertService;
import service.OrderService;
import util.Validate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ExpertServiceImpl extends BaseEntityServiceImpl<Expert,Integer, ExpertRepository> implements ExpertService {
    private final OrderService orderService;
    public ExpertServiceImpl(ExpertRepository repository,OrderService orderService) {
        super(repository);
        this.orderService=orderService;
    }

    @Override
    public String signUp(Expert expert) {
        if (Validate.nameValidation(expert.getFirstName()) &&
                Validate.nameValidation(expert.getLastName()) &&
                Validate.emailValidation(expert.getEmail()) &&
                Validate.passwordValidation(expert.getPassword())) {
            expert.setConfirmation(Confirmation.New);
            repository.saveOrUpdate(expert);
            return "successfully signUp";

        }
        return "failed to signUp";
    }

    @Override
    public List<Order> seeOrder(Integer expertId) {
       return repository.seeOrder(expertId);


    }

    @Override
    public Order acceptOrder(Integer orderId) {
        try {
            Order order = orderService.findById(orderId).orElse(null);
            assert order != null;
            order.setOrderStatus(OrderStatus.Work_Being);
            orderService.saveOrUpdate(order);
            return order;
        }catch (NullPointerException e){
            System.out.println("wrong Order ID");
        }
        return null;
    }
}

