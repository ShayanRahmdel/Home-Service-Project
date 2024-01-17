package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.business.Comment;
import entity.business.SubDuty;
import repository.CommentRepository;
import repository.SubDutyRepository;
import service.CommentService;
import service.SubDutyService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class SubDutyServiceImpl extends BaseEntityServiceImpl<SubDuty, Integer, SubDutyRepository> implements SubDutyService {

    public SubDutyServiceImpl(SubDutyRepository repository) {
        super(repository);
    }

    @Override
    public List<SubDuty> seeSubDutyByCategory(Integer category) {
        List<SubDuty> subDutyList = new ArrayList<>();
        Collection<SubDuty> allSubDuty = repository.findAll();
        for (SubDuty subDuty : allSubDuty){
            if (Objects.equals(subDuty.getDutyCategory().getId(), category)){
                subDutyList.add(subDuty);
            }

        }
        return subDutyList;
    }

    @Override
    public void updateSubDuty(Integer subDutyId, String newDescription, Double newPrice) {
        try {
            SubDuty subDuty = repository.findById(subDutyId).orElse(null);
            assert subDuty != null;
            subDuty.setDescription(newDescription);
            subDuty.setBasePrice(newPrice);
            repository.saveOrUpdate(subDuty);
        }catch (NullPointerException e){
            System.out.println("Error : wrong Id");
        }

    }
}
