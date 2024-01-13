package service;

import base.service.BaseEntityService;
import entity.users.Customer;
import entity.users.Expert;

public interface ExpertService extends BaseEntityService<Expert,Integer> {

    String signUp(Expert expert);
}
