package com.ing.Soft.services;

import java.util.List;
import java.util.Optional;
import com.ing.Soft.dtos.CourseDto;
import com.ing.Soft.entities.Course;
import com.ing.Soft.repositories.CourseRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CourseService {
    
    final CourseRepository courseRepository;

    final FeedbackService feedbackService;

    public CourseService(CourseRepository courseRepository, FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourseList(){
        return courseRepository.findAll();
    }
  
    public Optional<Course> findById(Long id){
        return courseRepository.findById(id);
    }

    public void saveCourse(Course course){
        //course.setStudentsNo(0);  -> default on database
        courseRepository.save(course);
    }


    public List<CourseDto> getAllCourseDtos(){
        return courseRepository.findCourseDtos();
    }

}
