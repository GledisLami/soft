package com.ing.Soft.services;


import com.ing.Soft.entities.Course;
import com.ing.Soft.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;


    public List<Course> getCourseList(){
        return courseRepository.findAll();
    }
    public List<Course> getCourseList(Integer studentNo){
        return courseRepository.findAllCourseByStudentsNo(studentNo);
    }
}
