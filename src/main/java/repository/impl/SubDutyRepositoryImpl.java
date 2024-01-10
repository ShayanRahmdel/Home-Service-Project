package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.business.SubDuty;
import repository.SubDutyRepository;

import javax.persistence.EntityManager;

public class SubDutyRepositoryImpl extends BaseEntityRepositoryImpl<SubDuty,Integer> implements SubDutyRepository {
    public SubDutyRepositoryImpl(EntityManager entityManager) {
        super();
    }

    @Override
    public Class<SubDuty> getEntityClass() {
        return SubDuty.class;
    }
}
