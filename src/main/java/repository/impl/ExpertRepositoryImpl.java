package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.users.Expert;
import repository.ExpertRepository;

import javax.persistence.EntityManager;

public class ExpertRepositoryImpl extends BaseEntityRepositoryImpl<Expert,Integer> implements ExpertRepository {
    public ExpertRepositoryImpl(EntityManager entityManager) {
        super();
    }

    @Override
    public Class<Expert> getEntityClass() {
        return Expert.class;
    }
}
