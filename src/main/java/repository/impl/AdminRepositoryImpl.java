package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.users.Admin;
import repository.AdminRepository;

import javax.persistence.EntityManager;

public class AdminRepositoryImpl extends BaseEntityRepositoryImpl<Admin,Integer> implements
        AdminRepository {
    public AdminRepositoryImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }
}
