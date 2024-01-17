package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.business.Order;
import entity.enumration.Confirmation;
import entity.enumration.OrderStatus;
import entity.users.Expert;
import repository.ExpertRepository;
import service.ExpertService;
import service.OrderService;
import util.Validate;
import java.util.List;

public class ExpertServiceImpl extends BaseEntityServiceImpl<Expert,Integer, ExpertRepository> implements ExpertService {
    private final OrderService orderService;
    public ExpertServiceImpl(ExpertRepository repository,OrderService orderService) {
        super(repository);
        this.orderService=orderService;
    }

    @Override
    public Expert signUp(Expert expert) {
        if (Validate.nameValidation(expert.getFirstName()) &&
                Validate.nameValidation(expert.getLastName()) &&
                Validate.emailValidation(expert.getEmail()) &&
                Validate.passwordValidation(expert.getPassword())) {
            expert.setConfirmation(Confirmation.New);
            repository.saveOrUpdate(expert);
            return expert;

        }
        return expert;
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

