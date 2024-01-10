package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.business.Comment;
import entity.business.DutyCategory;
import repository.CommentRepository;
import repository.DutyCategoryRepository;
import service.CommentService;
import service.DutyCategoryService;

public class DutyCategoryServiceImpl extends BaseEntityServiceImpl<DutyCategory, Integer, DutyCategoryRepository>
        implements DutyCategoryService {
    public DutyCategoryServiceImpl(DutyCategoryRepository repository) {
        super(repository);
    }
}
