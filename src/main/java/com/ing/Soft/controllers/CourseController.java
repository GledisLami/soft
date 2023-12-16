package com.ing.Soft.controllers;

import com.ing.Soft.entities.Course;
import com.ing.Soft.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courseList")
    public List<Course> getCourseList(){
        return courseService.getCourseList();
    }

    @GetMapping("/courseList")
    public List<Course> getCourseList(Integer studentNo){
        return courseService.getCourseList(studentNo);
    }


}
