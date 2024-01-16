package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.business.Order;
import entity.users.Expert;
import repository.ExpertRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

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

    @Override
    public List<Order> seeOrder(Integer expertId) {
        String hql="SELECT o FROM Order o " +
                "JOIN o.subDuty sd " +
                "JOIN sd.experts e " +
                "WHERE e.id = :expertId";
        TypedQuery<Order> query = entityManager.createQuery(hql, Order.class);
        query.setParameter("expertId", expertId);
        return query.getResultList();
    }
}
