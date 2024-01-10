package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.business.Comment;
import entity.business.WorkSuggestion;
import repository.CommentRepository;
import repository.WorkSuggestionRepository;
import service.CommentService;
import service.WorkSuggestionService;

public class WorkSuggestionServiceImpl extends BaseEntityServiceImpl<WorkSuggestion,Integer, WorkSuggestionRepository>
        implements WorkSuggestionService {
    public WorkSuggestionServiceImpl(WorkSuggestionRepository repository) {
        super(repository);
    }
}
