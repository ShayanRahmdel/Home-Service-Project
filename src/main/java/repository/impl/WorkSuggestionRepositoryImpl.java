package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.business.WorkSuggestion;
import repository.WorkSuggestionRepository;

import javax.persistence.EntityManager;

public class WorkSuggestionRepositoryImpl extends BaseEntityRepositoryImpl<WorkSuggestion,Integer> implements WorkSuggestionRepository {
    public WorkSuggestionRepositoryImpl(EntityManager entityManager) {
        super();
    }

    @Override
    public Class<WorkSuggestion> getEntityClass() {
        return WorkSuggestion.class;
    }
}
