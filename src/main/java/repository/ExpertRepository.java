package repository;

import base.repository.BaseEntityRepository;
import entity.users.Expert;

public interface ExpertRepository extends BaseEntityRepository<Expert,Integer> {

    void changePassword(String email, String oldPassword,String newPassword);
}
