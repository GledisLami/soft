package com.ing.Soft.repositories;

import com.ing.Soft.dtos.CourseDto;
import com.ing.Soft.entities.Course;
import com.ing.Soft.interfaces.CourseInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
@Repository
public interface CourseRepository extends JpaRepository <Course, Integer> {

    Optional<Course> findById(Integer id);
    Optional<Course> findByName(String name);

    @Query(value = "SELECT a.id as id, a.name as name, u.name as teacher, a.students_no as studentsNo, c.average as average " +
            "FROM course a " +
            "JOIN teacher_enrollment te ON a.id = te.course_id " +
            "JOIN user u ON u.id = te.user_id " +
            "JOIN feedback_average c ON a.id = c.course_id", nativeQuery = true)
    List<CourseInterface> findCourseDtos();
    //finds all courses that have a teacher, no feedbacks: average = 0


    @Query(value = "SELECT a.id as id, a.name as name, u.name as teacher, a.students_no as studentsNo, c.average as average " +
            "FROM course a " +
            "JOIN teacher_enrollment te ON a.id = te.course_id " +
            "JOIN user u ON u.id = te.user_id " +
            "JOIN feedback_average c ON a.id = c.course_id " +
            "WHERE a.id = :id", nativeQuery = true)
    CourseInterface findCourseDto(Integer id); //find by course id

    // TODO: ALEKSANDER top 8 courses method + all methods should be on the 3 tiers for course + coursedto
}
