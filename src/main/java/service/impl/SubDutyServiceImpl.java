package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.business.Comment;
import entity.business.SubDuty;
import repository.CommentRepository;
import repository.SubDutyRepository;
import service.CommentService;
import service.SubDutyService;

public class SubDutyServiceImpl extends BaseEntityServiceImpl<SubDuty, Integer, SubDutyRepository> implements SubDutyService {

    public SubDutyServiceImpl(SubDutyRepository repository) {
        super(repository);
    }
}
