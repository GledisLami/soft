package com.ing.Soft.services;

import com.ing.Soft.entities.Course;
import com.ing.Soft.entities.StudentEnrollment;
import com.ing.Soft.entities.User;
import com.ing.Soft.repositories.CourseRepository;
import com.ing.Soft.repositories.StudentEnrollmentRepository;
import com.ing.Soft.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


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

    public void enrollStudent(Integer course_id, Integer user_id) {

        Course course = courseRepository.findById(course_id).get();
        User user = userRepository.findById(user_id).get();
        //kontrollojme nese ky student eshte i rregjistruar, qe te mos ruhen entitetet disa here
        List<StudentEnrollment> pastEnrollment = studentEnrollmentRepository.findListByUserAndCourseId(user_id, course_id);
        if (!(pastEnrollment.isEmpty())){
            studentEnrollmentRepository.deleteAll(pastEnrollment);
        }
        StudentEnrollment studentEnrollment = new StudentEnrollment(course, user);
        studentEnrollmentRepository.save(studentEnrollment);
    }

    public void unenrollStudent(Integer course_id, Integer user_id) {
        StudentEnrollment enrollmentToDelete = studentEnrollmentRepository.findByUserAndCouseId(user_id, course_id).get();
        enrollmentToDelete.getCourse().setStudentsNo(enrollmentToDelete.getCourse().getStudentsNo()-1);
        studentEnrollmentRepository.delete(enrollmentToDelete);
    }

}