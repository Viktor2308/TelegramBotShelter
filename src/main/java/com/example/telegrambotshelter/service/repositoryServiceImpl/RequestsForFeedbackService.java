package com.example.telegrambotshelter.service.repositoryServiceImpl;

import com.example.telegrambotshelter.entity.RequestsForFeedback;
import com.example.telegrambotshelter.repository.RequestsForFeedbackRepository;
import com.example.telegrambotshelter.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
@AllArgsConstructor
public class RequestsForFeedbackService implements RepositoryService<RequestsForFeedback> {

    private final RequestsForFeedbackRepository requestsForFeedbackRepository;

    @Override
    public void add(RequestsForFeedback requestsForFeedback) {
        requestsForFeedbackRepository.save(requestsForFeedback);
    }

    @Override
    public RequestsForFeedback get(long id) {
        return requestsForFeedbackRepository.findById(id).orElseThrow(
                () -> new ResolutionException("Requests for feedback with id " + id + " not found"));
    }

    @Override
    public List<RequestsForFeedback> getAll() {
        return null;
    }

    @Override
    public void update(RequestsForFeedback requestsForFeedback) {

    }

    @Override
    public void delete(RequestsForFeedback requestsForFeedback) {

    }

}
