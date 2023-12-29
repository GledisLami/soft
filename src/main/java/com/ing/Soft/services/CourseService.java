package com.ing.Soft.services;

import java.util.List;
import java.util.Optional;

import com.ing.Soft.dtos.CourseDto;
import com.ing.Soft.dtos.CourseDtoDetailed;
import com.ing.Soft.entities.Course;
import com.ing.Soft.repositories.CourseRepository;
import com.ing.Soft.util.CourseDtoMapper;
import org.springframework.stereotype.Service;

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
  
    public Optional<Course> findById(Integer id){
        return courseRepository.findById(id);
    }

    public void saveCourse(Course course){
        courseRepository.save(course);
    }


    public List<CourseDto> getAllCourseDtos(){
        return CourseDtoMapper.mapToCourseDto(courseRepository::findCourseDtos, CourseDto.class);
    }

    public List<CourseDto> findTop8ByOrderByAverageDesc(){
        return CourseDtoMapper.mapToCourseDto(courseRepository::findTop8ByOrderByAverageDesc, CourseDto.class);
    }

    public List<CourseDto> getEnrolledCoursesForStudent(Integer user_id) {
        return CourseDtoMapper.mapToCourseDto(() -> courseRepository.findCourseDtosByUserId(user_id), CourseDto.class);
    }


    public CourseDto getCourseDto(Integer id){
        return new CourseDto(courseRepository.findCourseDto(id));
    }


    public CourseDtoDetailed getCourseDtoDetailed(Integer id) {
        return new CourseDtoDetailed(courseRepository.findCourseDtoDetailed(id));
    }

}
