package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.business.Comment;
import entity.users.Expert;
import repository.CommentRepository;
import repository.ExpertRepository;
import service.CommentService;
import service.ExpertService;
import util.Validate;

public class ExpertServiceImpl extends BaseEntityServiceImpl<Expert,Integer, ExpertRepository> implements ExpertService {
    public ExpertServiceImpl(ExpertRepository repository) {
        super(repository);
    }

    @Override
    public String signUp(Expert expert) {
        if (Validate.nameValidation(expert.getFirstName()) &&
                Validate.nameValidation(expert.getLastName()) &&
                Validate.emailValidation(expert.getEmail()) &&
                Validate.passwordValidation(expert.getPassword())){

        }
    }




}
