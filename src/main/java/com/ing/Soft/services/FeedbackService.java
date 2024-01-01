package com.ing.Soft.services;

import com.ing.Soft.dtos.FeedbackDto;
import com.ing.Soft.entities.Feedback;
import com.ing.Soft.entities.StudentEnrollment;
import com.ing.Soft.repositories.FeedbackRepository;
import com.ing.Soft.repositories.StudentEnrollmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.sql.Date;
import java.util.stream.Collectors;


@Service
public class FeedbackService {

    final FeedbackRepository feedbackRepository;

    final StudentEnrollmentRepository studentEnrollmentRepository;

    public FeedbackService(FeedbackRepository feedbackRepository, StudentEnrollmentRepository studentEnrollmentRepository) {
        this.feedbackRepository = feedbackRepository;
        this.studentEnrollmentRepository = studentEnrollmentRepository;
    }

    //duhet kthyer dto pasi Feedback ben join dhe kthen shume te dhena
    public List<FeedbackDto> findAllDtos(){
        return feedbackRepository.findAll()
                .stream()
                .map(FeedbackDto::new)
                .collect(Collectors.toList());
    }

    public List<Feedback> findAll(){
        return feedbackRepository.findAll();
    }

    public Optional<FeedbackDto> findById(Integer id){
        return Optional.of(new FeedbackDto(feedbackRepository.findById(id).get()));
    }

    public String saveFeedback(FeedbackDto feedbackDto) {
        //Restrict leaving a feedback if a student is not enrolled
        Optional<StudentEnrollment> enrolledStudent =
                studentEnrollmentRepository.findByUserAndCouseId(feedbackDto.getUserId(), feedbackDto.getCourseId());
        Optional<Feedback> feedbackSearch = feedbackRepository.
                findByUserAndCourseId(feedbackDto.getCourseId(),feedbackDto.getUserId());

        if (!(enrolledStudent.isPresent()) || feedbackSearch.isPresent()){ //ose njera ose tjetra duhet te mos lejojne
            //dmth qe ky student nuk eshte ne ate kurs
            return "Nuk mund te lesh pershkrim!!!";
        }
        Feedback feedback = Feedback.fromDTO(feedbackDto);
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

    public List<FeedbackDto> findByCourseId(Integer courseId){
        return feedbackRepository.findByCourseId(courseId)
                .stream()
                .map(FeedbackDto::new)
                .collect(Collectors.toList());
    }
}