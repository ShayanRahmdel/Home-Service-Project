package service;

import base.service.BaseEntityService;
import entity.business.Order;
import entity.users.Customer;
import entity.users.Expert;

import java.io.File;
import java.util.List;

public interface ExpertService extends BaseEntityService<Expert,Integer> {

    Expert signUp(Expert expert, File image);

    void changePassword(String email, String oldPassword,String newPassword);

    List<Order> seeOrder(Integer expertId);

    Order acceptOrder(Integer orderId);

    void saveImage(String imagePath,Integer expertId);

}
