package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.business.Comment;
import entity.business.DutyCategory;
import repository.CommentRepository;
import repository.DutyCategoryRepository;
import service.CommentService;
import service.DutyCategoryService;

public class DutyCategoryServiceImpl extends BaseEntityServiceImpl<DutyCategory, Integer, DutyCategoryRepository>
        implements DutyCategoryService {
    public DutyCategoryServiceImpl(DutyCategoryRepository repository) {
        super(repository);
    }

    @Override
    public void updateDutyCategory(Integer dutyCategoryId ,String newTitle) {
        try {
            DutyCategory dutyCategory = repository.findById(dutyCategoryId).orElse(null);
            assert dutyCategory != null;
            dutyCategory.setTitle(newTitle);
            repository.saveOrUpdate(dutyCategory);
        }catch (NullPointerException e){
            System.out.println("Error: Wrong Id");
        }


    }
}
