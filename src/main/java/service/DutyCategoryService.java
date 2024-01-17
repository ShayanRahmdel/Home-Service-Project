package service;

import base.service.BaseEntityService;
import entity.business.DutyCategory;
import entity.users.Customer;

public interface DutyCategoryService extends BaseEntityService<DutyCategory,Integer> {

    void updateDutyCategory(Integer dutyCategoryId,String newTitle);
}
