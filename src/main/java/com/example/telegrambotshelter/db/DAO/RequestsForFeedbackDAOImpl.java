package com.example.telegrambotshelter.db.DAO;

import com.example.telegrambotshelter.db.entity.RequestsForFeedback;
import com.example.telegrambotshelter.db.repository.RequestsForFeedbackRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
@AllArgsConstructor
public class RequestsForFeedbackDAOImpl implements DAO<RequestsForFeedback> {

    private final RequestsForFeedbackRepositoryJPA requestsForFeedbackRepositoryJPA;

    @Override
    public RequestsForFeedback add(RequestsForFeedback requestsForFeedback) {
        return requestsForFeedbackRepositoryJPA.save(requestsForFeedback);
    }

    @Override
    public RequestsForFeedback getById(long id) {
        return requestsForFeedbackRepositoryJPA.findById(id).orElseThrow(
                () -> new ResolutionException("Requests for feedback with id " + id + " not found"));
    }

    @Override
    public List<RequestsForFeedback> getAll() {
        return null;
    }

    @Override
    public RequestsForFeedback update(RequestsForFeedback requestsForFeedback, long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

}
