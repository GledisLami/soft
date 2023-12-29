package com.ing.Soft.services;

import com.ing.Soft.dtos.CourseDto;
import com.ing.Soft.entities.Course;
import com.ing.Soft.entities.StudentEnrollment;
import com.ing.Soft.entities.User;
import com.ing.Soft.interfaces.CourseInterface;
import com.ing.Soft.repositories.CourseRepository;
import com.ing.Soft.repositories.StudentEnrollmentRepository;
import com.ing.Soft.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentEnrollmentService {
    private final StudentEnrollmentRepository studentEnrollmentRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public StudentEnrollmentService(StudentEnrollmentRepository studentEnrollmentRepository, CourseRepository courseRepository, UserRepository userRepository) {
        this.studentEnrollmentRepository = studentEnrollmentRepository;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;

    }

    public void enrollStudent(Integer user_id, Integer course_id) {

        StudentEnrollment studentEnrollment = new StudentEnrollment();
        Course course = courseRepository.findById(course_id).get();
        User user = userRepository.findById(user_id).get();

        studentEnrollment.setCourse(course);
        studentEnrollment.setUser(user);

    }

    public void unenrollStudent(Integer course_id, Integer user_id) {
        StudentEnrollment enrollmentToDelete = studentEnrollmentRepository.findByStudentAndCourseId(user_id, course_id);
        studentEnrollmentRepository.delete(enrollmentToDelete);
    }

    public List<CourseDto> getEnrolledCoursesForStudent(Integer student_id) {

        List<CourseInterface> courseDtos = studentEnrollmentRepository.findCourseDtosByUserId(student_id);
        List<CourseDto> courses = new ArrayList<>();
        for(CourseInterface course: courseDtos){
            CourseDto dto = new CourseDto();
            dto.setId(course.getId());
            dto.setName(course.getName());
            dto.setAverage(course.getAverage());
            dto.setStudentsNo(course.getStudentsNo());
            dto.setTeacher(course.getTeacher());

        }
        return courses;
    }
}