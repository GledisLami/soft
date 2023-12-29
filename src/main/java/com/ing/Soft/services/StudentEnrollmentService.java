package com.ing.Soft.services;

import com.ing.Soft.entities.Course;
import com.ing.Soft.entities.StudentEnrollment;
import com.ing.Soft.entities.User;
import com.ing.Soft.repositories.CourseRepository;
import com.ing.Soft.repositories.StudentEnrollmentRepository;
import com.ing.Soft.repositories.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class StudentEnrollmentService {
    private final StudentEnrollmentRepository studentEnrollmentRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public StudentEnrollmentService(StudentEnrollmentRepository studentEnrollmentRepository, CourseRepository courseRepository, UserRepository userRepository) {
        this.studentEnrollmentRepository = studentEnrollmentRepository;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;

    }

    public void enrollStudent(Integer user_id, Integer course_id) {

        Course course = courseRepository.findById(course_id).get();
        User user = userRepository.findById(user_id).get();
        StudentEnrollment studentEnrollment = new StudentEnrollment(course, user);
        studentEnrollmentRepository.save(studentEnrollment);
    }

    public void unenrollStudent(Integer course_id, Integer user_id) {
        StudentEnrollment enrollmentToDelete = studentEnrollmentRepository.findByStudentAndCourseId(user_id, course_id);
        studentEnrollmentRepository.delete(enrollmentToDelete);
    }

}