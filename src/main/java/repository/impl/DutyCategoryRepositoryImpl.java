package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.business.DutyCategory;
import repository.DutyCategoryRepository;

import javax.persistence.EntityManager;

public class DutyCategoryRepositoryImpl extends BaseEntityRepositoryImpl<DutyCategory,Integer> implements DutyCategoryRepository {
    public DutyCategoryRepositoryImpl(EntityManager entityManager) {
        super();
    }


    @Override
    public Class<DutyCategory> getEntityClass() {
        return DutyCategory.class;
    }
}
