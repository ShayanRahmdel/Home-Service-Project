package service;

import base.service.BaseEntityService;
import entity.business.SubDuty;
import entity.users.Customer;

import java.util.List;

public interface SubDutyService extends BaseEntityService<SubDuty,Integer> {

    List<SubDuty> seeSubDutyByCategory(Integer category);


}
