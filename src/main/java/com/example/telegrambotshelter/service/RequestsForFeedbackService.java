package com.example.telegrambotshelter.service;

import com.example.telegrambotshelter.entity.RequestsForFeedback;
import com.example.telegrambotshelter.repository.RequestsForFeedbackRepository;
import org.springframework.stereotype.Service;

@Service
public class RequestsForFeedbackService {

    private final RequestsForFeedbackRepository requestsForFeedbackRepository;

    public RequestsForFeedbackService(RequestsForFeedbackRepository requestsForFeedbackRepository) {
        this.requestsForFeedbackRepository = requestsForFeedbackRepository;
    }

    public void saveRequestsForFeedback(RequestsForFeedback requestsForFeedback){
        requestsForFeedbackRepository.save(requestsForFeedback);
    }
}
