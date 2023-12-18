package com.ing.Soft.job;

import com.ing.Soft.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OldFeedbackRemoval {

    private final FeedbackService feedbackService;

    public OldFeedbackRemoval(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @Scheduled(cron = "0 0 0 * * ?") // Run every day at midnight
    public void removeOldFeedbackJob() {
        feedbackService.removeOldFeedback();
    }
}
