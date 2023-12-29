package com.ing.Soft.controllers;

import com.ing.Soft.dtos.CourseDto;
import com.ing.Soft.entities.StudentEnrollment;
import com.ing.Soft.services.StudentEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class StudentEnrollmentController {

    @Autowired
     StudentEnrollmentService studentEnrollmentService;

    @PostMapping
    public void enrollStudent(@RequestParam Integer course_id, @RequestParam Integer user_id) {
        studentEnrollmentService.enrollStudent(course_id, user_id);

    }

    @DeleteMapping("/unenroll")
    public void unenrollStudents(@RequestParam Integer course_id, @RequestParam Integer user_id) {
    }

    @GetMapping("/getEnrolledCourses/studentId")
    public List<CourseDto> getEnrolledCoursesForStudent(@RequestParam Integer studentId) {
        return studentEnrollmentService.getEnrolledCoursesForStudent(studentId);

    }
}

