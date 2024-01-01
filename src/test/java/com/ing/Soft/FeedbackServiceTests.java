package com.ing.Soft;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.ing.Soft.dtos.FeedbackDto;
import com.ing.Soft.entities.Feedback;
import com.ing.Soft.entities.StudentEnrollment;
import com.ing.Soft.repositories.FeedbackRepository;
import com.ing.Soft.repositories.StudentEnrollmentRepository;

import com.ing.Soft.services.FeedbackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

public class FeedbackServiceTests {

    private FeedbackService feedbackService;
    private FeedbackRepository feedbackRepository;
    private StudentEnrollmentRepository studentEnrollmentRepository;

    @BeforeEach
    public void setUp() {
        feedbackRepository = mock(FeedbackRepository.class);
        studentEnrollmentRepository = mock(StudentEnrollmentRepository.class);
        feedbackService = new FeedbackService(feedbackRepository, studentEnrollmentRepository);
    }

    @Test
    public void testFindAll() {
        Feedback feedback1 = new Feedback();
        Feedback feedback2 = new Feedback();
        when(feedbackRepository.findAll()).thenReturn(Arrays.asList(feedback1, feedback2));

        List<Feedback> result = feedbackService.findAll();

        assertEquals(2, result.size());
    }

    @Test
    public void testSaveFeedback() {
        
        FeedbackDto feedbackDto = new FeedbackDto();
        when(studentEnrollmentRepository.findByUserAndCouseId(any(), any())).thenReturn(Optional.of(new StudentEnrollment()));
        when(feedbackRepository.findByUserAndCourseId(any(), any())).thenReturn(Optional.empty());

        
        String result = feedbackService.saveFeedback(feedbackDto);

        
        assertEquals("U ruajt me sukses", result);
        verify(feedbackRepository, times(1)).save(any());
    }

    @Test
    public void testSaveFeedback_NotEnrolled() {
        
        FeedbackDto feedbackDto = new FeedbackDto();
        when(studentEnrollmentRepository.findByUserAndCouseId(any(), any())).thenReturn(Optional.empty());

        
        String result = feedbackService.saveFeedback(feedbackDto);

        
        assertEquals("Nuk mund te lesh pershkrim!!!", result);
        verify(feedbackRepository, never()).save(any());
    }

    @Test
    public void testSaveFeedback_AlreadyExists() {
        
        FeedbackDto feedbackDto = new FeedbackDto();
        when(studentEnrollmentRepository.findByUserAndCouseId(any(), any())).thenReturn(Optional.of(new StudentEnrollment()));
        when(feedbackRepository.findByUserAndCourseId(any(), any())).thenReturn(Optional.of(new Feedback()));

        
        String result = feedbackService.saveFeedback(feedbackDto);

        
        assertEquals("Nuk mund te lesh pershkrim!!!", result);
        verify(feedbackRepository, never()).save(any());
    }

    @Test
    public void testDeleteFeedback() {
        
        feedbackService.deleteFeedback(1);

        
        verify(feedbackRepository, times(1)).deleteById(1);
    }

    @Test
    @Transactional
    public void testRemoveOldFeedback() {
        
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        Date oneYearAgoSqlDate = Date.valueOf(oneYearAgo);
        Feedback oldFeedback1 = new Feedback();
        Feedback oldFeedback2 = new Feedback();
        when(feedbackRepository.findByDateBefore(oneYearAgoSqlDate)).thenReturn(Arrays.asList(oldFeedback1, oldFeedback2));

        
        feedbackService.removeOldFeedback();

        
        verify(feedbackRepository, times(1)).deleteAll(Arrays.asList(oldFeedback1, oldFeedback2));
    }

}

