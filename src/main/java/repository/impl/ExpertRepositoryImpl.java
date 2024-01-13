package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.users.Expert;
import repository.ExpertRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ExpertRepositoryImpl extends BaseEntityRepositoryImpl<Expert,Integer> implements ExpertRepository {
    public ExpertRepositoryImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    @Override
    public Class<Expert> getEntityClass() {
        return Expert.class;
    }

    @Override
    public void changePassword(String email, String oldPassword, String newPassword) {
        String hql = "UPDATE Expert e set e.password= :newPassword WHERE e.email= :email and e.password= :oldPassword";
        try {
            beginTransaction();
            Query query = entityManager.createQuery(hql);
            query.setParameter("newPassword",newPassword);
            query.setParameter("oldPassword",oldPassword);
            query.setParameter("email",email);
            query.executeUpdate();
            commitTransaction();
        }catch (IllegalArgumentException e){
            System.out.println("something went wrong");
            rollBack();
        }

    }
}
