package com.ing.Soft.services;

import com.ing.Soft.dtos.FeedbackDto;
import com.ing.Soft.entities.Feedback;
import com.ing.Soft.entities.StudentEnrollment;
import com.ing.Soft.entities.User;
import com.ing.Soft.repositories.FeedbackRepository;
import com.ing.Soft.repositories.StudentEnrollmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.sql.Date;


@Service
public class FeedbackService {

    final FeedbackRepository feedbackRepository;

    final StudentEnrollmentRepository studentEnrollmentRepository;

    public FeedbackService(FeedbackRepository feedbackRepository, StudentEnrollmentRepository studentEnrollmentRepository) {
        this.feedbackRepository = feedbackRepository;
        this.studentEnrollmentRepository = studentEnrollmentRepository;
    }

    public List<Feedback> findAll(){
        return feedbackRepository.findAll();
    }

    public Optional<Feedback> findById(Integer id){
        return feedbackRepository.findById(id);
    }

    public String saveFeedback(FeedbackDto feedbackDto) {
        //Restrict leaving a feedback if a student is not enrolled
        Optional<StudentEnrollment> enrolledStudent =
                studentEnrollmentRepository.findByUserAndCouseId(feedbackDto.getUser().getId(), feedbackDto.getCourse().getId());
        Optional<Feedback> feedbackSearch = feedbackRepository.
                findByUserAndCourseId(feedbackDto.getCourse().getId(),feedbackDto.getUser().getId());
        if (enrolledStudent.isEmpty() || feedbackSearch.isPresent()){ //ose njera ose tjetra duhet te mos lejojne
            //dmth qe ky student nuk eshte ne ate kurs
            return "Nuk mund te lesh pershkrim!!!";
        }
        Feedback feedback = new Feedback();
        feedback.setCourse(feedbackDto.getCourse());
        feedback.setUser(feedbackDto.getUser());
        feedback.setRating(feedbackDto.getRating());
        feedback.setDescription(feedbackDto.getDescription());
        feedback.setDate(feedback.getDate());
        feedbackRepository.save(feedback);
        return "U ruajt me sukses";
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