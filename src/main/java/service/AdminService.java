package service;

import base.service.BaseEntityService;
import entity.business.DutyCategory;
import entity.business.SubDuty;
import entity.users.Admin;
import entity.users.Customer;
import entity.users.Expert;

import java.util.List;

public interface AdminService extends BaseEntityService<Admin,Integer> {

    DutyCategory createDutyCategory(DutyCategory dutyCategory);

    SubDuty createSubDuty(SubDuty subDuty,Integer category);

    List<Customer> seeAllCustomer();

    List<Expert> seeAllExpert();

    List<DutyCategory> seeAllDutyCategories();
    List<SubDuty> seeAllSubDuty();

    void addExpertInSubDuty(Integer expertId,Integer subDutyId);

    void confirmExpert(Integer expertId);
    void removeExpertFromSubDuty(Integer expertId,Integer subDutyId);

    boolean validateExpertOneDutyCategory(Expert expert,Integer newDutyCategory);

    void removeDutyCategory(Integer dutyCategoryId);

    void removeSubDuty(Integer subDutyId);

    void removeCustomer(Integer customerId);

    void removeExpert(Integer expertId);

}
