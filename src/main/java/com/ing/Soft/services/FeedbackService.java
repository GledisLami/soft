package com.ing.Soft.services;

import com.ing.Soft.entities.Feedback;
import com.ing.Soft.repositories.FeedbackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.sql.Date;

@Service
public class FeedbackService {

    final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public List<Feedback> findAll(){
        return feedbackRepository.findAll();
    }

    public Optional<Feedback> findById(Integer id){
        return feedbackRepository.findById(id);
    }

    public void saveFeedback(Feedback feedback){
        feedbackRepository.save(feedback);
    }

    public void deleteFeedback(Integer id){
        feedbackRepository.deleteById(id);
    }

    @Transactional
    public void removeOldFeedback(){
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        Date oneYearAgoSqlDate = Date.valueOf(oneYearAgo);
        List<Feedback> oldFeedback = feedbackRepository.findByDateBefore(oneYearAgoSqlDate);
        feedbackRepository.deleteAll(oldFeedback);
    }

    public List<Feedback> findByCourseId(Integer courseId){
        return feedbackRepository.findByCourseId(courseId);
    }
}
