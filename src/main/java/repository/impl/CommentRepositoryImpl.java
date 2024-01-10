package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.business.Comment;
import repository.CommentRepository;

import javax.persistence.EntityManager;

public class CommentRepositoryImpl extends BaseEntityRepositoryImpl<Comment,Integer> implements CommentRepository {
    public CommentRepositoryImpl(EntityManager entityManager) {
        super();
    }

    @Override
    public Class<Comment> getEntityClass() {
        return Comment.class;
    }
}
