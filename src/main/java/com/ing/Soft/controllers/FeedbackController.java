package com.ing.Soft.controllers;

import com.ing.Soft.dtos.FeedbackDto;
import com.ing.Soft.entities.Feedback;
import com.ing.Soft.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/feedback")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;
    @GetMapping
    public List<Feedback> findAll(){
        return feedbackService.findAll();
    }

    @GetMapping
    public Optional<Feedback> findById(@RequestParam Integer id){
        return feedbackService.findById(id);
    }
    @PostMapping
    public String saveFeedback(@RequestBody FeedbackDto feedback){
        return feedbackService.saveFeedback(feedback);
    }
    @DeleteMapping
    public void deleteFeedback(@RequestParam Integer id){
        feedbackService.deleteFeedback(id);
    }
    @GetMapping
    public List<Feedback> findByCourseId(@RequestParam Integer courseId) {
        return feedbackService.findByCourseId(courseId);

    }
}
