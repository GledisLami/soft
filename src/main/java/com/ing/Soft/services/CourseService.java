package com.ing.Soft.services;

import com.ing.Soft.entities.Course;
import com.ing.Soft.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Optional<Course> findById(Long id){
        return courseRepository.findById(id);
    }
}
