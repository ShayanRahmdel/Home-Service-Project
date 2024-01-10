package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.business.Comment;
import repository.CommentRepository;
import service.CommentService;

public class CommentServiceImpl extends BaseEntityServiceImpl<Comment,Integer, CommentRepository>
        implements CommentService {
    public CommentServiceImpl(CommentRepository repository) {
        super(repository);
    }
}
