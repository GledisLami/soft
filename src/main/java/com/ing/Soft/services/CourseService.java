package com.ing.Soft.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.ing.Soft.dtos.CourseDto;
import com.ing.Soft.dtos.CourseDtoDetailed;
import com.ing.Soft.entities.Course;
import com.ing.Soft.interfaces.CourseDetailedInterface;
import com.ing.Soft.interfaces.CourseInterface;
import com.ing.Soft.repositories.CourseRepository;
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
        //course.setStudentsNo(0);  -> default on database
        courseRepository.save(course);
    }


    public List<CourseDto> getAllCourseDtos(){
        List<CourseInterface> courseInterfaceList = courseRepository.findCourseDtos();
        List<CourseDto> courseDtoList = new ArrayList<>();
        for (CourseInterface courseInterface : courseInterfaceList) {
            CourseDto courseDto = new CourseDto();
            courseDto.setId(courseInterface.getId());
            courseDto.setName(courseInterface.getName());
            courseDto.setTeacher(courseInterface.getTeacher());
            courseDto.setStudentsNo(courseInterface.getStudentsNo());
            courseDto.setAverage(courseInterface.getAverage());
            courseDtoList.add(courseDto);
        }
        return courseDtoList;
    }

    public List<CourseDtoDetailed> findTop8ByOrderByAverageDesc(){
        List<CourseDetailedInterface> courseDetailedInterfacelist = courseRepository.findTop8ByOrderByAverageDesc();
        List<CourseDtoDetailed> courseDtoDetailedlist = new ArrayList<>();
        for (CourseDetailedInterface courseDetailedInterface : courseDetailedInterfacelist){
            CourseDtoDetailed courseDtoDetailed = new CourseDtoDetailed();
            courseDtoDetailed.setId(courseDetailedInterface.getId());
            courseDtoDetailed.setName(courseDetailedInterface.getName());
            courseDtoDetailed.setTeacher(courseDetailedInterface.getTeacher());
            courseDtoDetailed.setDescription(courseDetailedInterface.getDescription());
            courseDtoDetailed.setAverage(courseDetailedInterface.getAverage());
            courseDtoDetailed.setStudentsNo(courseDetailedInterface.getStudentsNo());
            courseDtoDetailed.setTime(courseDetailedInterface.getTime());
            courseDtoDetailedlist.add(courseDtoDetailed);
        }
        return courseDtoDetailedlist;
    }


    public CourseDto getCourseDto(Integer id){
        CourseInterface courseInterface = courseRepository.findCourseDto(id);
        CourseDto courseDto = new CourseDto();
        courseDto.setName(courseInterface.getName());
        courseDto.setId(courseInterface.getId());
        courseDto.setTeacher(courseInterface.getTeacher());
        courseDto.setAverage(courseInterface.getAverage());
        courseDto.setStudentsNo(courseInterface.getStudentsNo());

        return courseDto;
    }


    public List<CourseDtoDetailed> getAllCourseDtoDetailed() {
        List<CourseDetailedInterface> courseDetailedInterfaceList = courseRepository.findAllCourseDtoDetailed();
        List<CourseDtoDetailed> courseDtoDetailedList = new ArrayList<>();
        for (CourseDetailedInterface courseDetailedInterface : courseDetailedInterfaceList){
            CourseDtoDetailed courseDtoDetailed = new CourseDtoDetailed();
            courseDtoDetailed.setName(courseDetailedInterface.getName());
            courseDtoDetailed.setId(courseDetailedInterface.getId());
            courseDtoDetailed.setTeacher(courseDetailedInterface.getTeacher());
            courseDtoDetailed.setAverage(courseDetailedInterface.getAverage());
            courseDtoDetailed.setStudentsNo(courseDetailedInterface.getStudentsNo());
            courseDtoDetailed.setTime(courseDetailedInterface.getTime());
            courseDtoDetailed.setDescription(courseDetailedInterface.getDescription());
            courseDtoDetailedList.add(courseDtoDetailed);
        }
    return courseDtoDetailedList;
    }

}
