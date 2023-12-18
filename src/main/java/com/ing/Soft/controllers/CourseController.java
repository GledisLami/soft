
package com.ing.Soft.controllers;

import com.ing.Soft.dtos.CourseDto;
import com.ing.Soft.entities.Course;
import com.ing.Soft.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/course")

public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping
    public void saveCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
    }

    @GetMapping("/id")
    public Optional<Course> findById(@RequestParam Integer id) {
        return courseService.findById(id);
    }

    @GetMapping
    public List<Course> getCourseList() {
        return courseService.getCourseList();
    }

    @GetMapping("/dto")
    public List<CourseDto> getAllCourseDtos() {
        return courseService.getAllCourseDtos();
    }

}
