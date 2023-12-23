package com.ing.Soft.controllers;

import com.ing.Soft.entities.StudentEnrollment;
import com.ing.Soft.services.StudentEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class StudentEnrollmentController {

    @Autowired
     StudentEnrollmentService enrollmentService;


    @PostMapping("/enroll")
    public void enrollStudent(@RequestBody StudentEnrollment enrollment) {
        enrollmentService.enrollStudent(enrollment);
    }

    @PostMapping("/unenroll")
    public void unenrollStudents(@RequestParam StudentEnrollment enrollmentId) {
        enrollmentService.unenrollStudent(enrollmentId);
    }

    @GetMapping("/getEnrolledCourses/studentId")
    public List<StudentEnrollment> getEnrolledCoursesForStudent(@RequestParam Integer studentId) {
        return enrollmentService.getEnrolledCoursesForStudents(studentId);

    }
}

