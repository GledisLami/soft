package com.ing.Soft;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.ing.Soft.entities.Course;
import com.ing.Soft.entities.StudentEnrollment;
import com.ing.Soft.entities.User;
import com.ing.Soft.repositories.CourseRepository;
import com.ing.Soft.repositories.StudentEnrollmentRepository;
import com.ing.Soft.repositories.UserRepository;

import com.ing.Soft.services.StudentEnrollmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentEnrollmentServiceTests {

    private StudentEnrollmentService studentEnrollmentService;
    private StudentEnrollmentRepository studentEnrollmentRepository;
    private CourseRepository courseRepository;
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        studentEnrollmentRepository = mock(StudentEnrollmentRepository.class);
        courseRepository = mock(CourseRepository.class);
        userRepository = mock(UserRepository.class);
        studentEnrollmentService = new StudentEnrollmentService(studentEnrollmentRepository, courseRepository, userRepository);
    }

    @Test
    public void testEnrollStudent() {
        User user = new User();
        Course course = new Course();
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(courseRepository.findById(1)).thenReturn(Optional.of(course));

        studentEnrollmentService.enrollStudent(1, 1);


        verify(studentEnrollmentRepository, times(1)).save(any());
    }

    @Test
    public void testUnenrollStudent() {
        User user = new User();
        Course course = new Course();
        StudentEnrollment enrollmentToDelete = new StudentEnrollment(course, user);
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(courseRepository.findById(1)).thenReturn(Optional.of(course));
        when(studentEnrollmentRepository.findByUserAndCouseId(1, 1)).thenReturn(Optional.of(enrollmentToDelete));

        studentEnrollmentService.unenrollStudent(1, 1);


        verify(studentEnrollmentRepository, times(1)).delete(enrollmentToDelete);
    }
}

