package com.ing.Soft.services;

import com.ing.Soft.entities.Course;
import com.ing.Soft.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CourseService {
    //I created a method for saving courses

    @Autowired
    CourseRepository courseRepository;



    public void saveCourse(Course course){
        course.setStudentsNo(0);
        courseRepository.save(course);
    }





}
