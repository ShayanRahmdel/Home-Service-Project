package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.business.Comment;
import entity.users.Expert;
import repository.CommentRepository;
import repository.ExpertRepository;
import service.CommentService;
import service.ExpertService;

public class ExpertServiceImpl extends BaseEntityServiceImpl<Expert,Integer, ExpertRepository> implements ExpertService {
    public ExpertServiceImpl(ExpertRepository repository) {
        super(repository);
    }
}
