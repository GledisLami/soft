package com.ing.Soft.services;

import com.ing.Soft.entities.StudentEnrollment;
import com.ing.Soft.repositories.StudentEnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentEnrollmentService {
    private final StudentEnrollmentRepository studentEnrollment;

    public StudentEnrollmentService(StudentEnrollmentRepository studentEnrollment) {
        this.studentEnrollment = studentEnrollment;

    }
    public void enrollStudent(StudentEnrollment enrollment){
        studentEnrollment.enrollStudent(enrollment);
    }
    public void unenrollStudent(StudentEnrollment enrollmentId){
        studentEnrollment.enrollStudent(enrollmentId);
    }
    public List<StudentEnrollment> getEnrolledCoursesForStudents(Integer studentId){
        return studentEnrollment.getEnrolledCoursesForStudents(studentId);
    }

}
