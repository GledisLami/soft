package com.ing.Soft.controllers;

import com.ing.Soft.services.StudentEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/enrollment")
public class StudentEnrollmentController {

    @Autowired
    StudentEnrollmentService studentEnrollmentService;

    @PostMapping
    public void enrollStudent(@RequestParam Integer course_id, @RequestParam Integer user_id) {
        studentEnrollmentService.enrollStudent(course_id, user_id);
    }

    @DeleteMapping
    public void unenrollStudents(@RequestParam Integer course_id, @RequestParam Integer user_id) {
        studentEnrollmentService.unenrollStudent(course_id, user_id);
    }


}

