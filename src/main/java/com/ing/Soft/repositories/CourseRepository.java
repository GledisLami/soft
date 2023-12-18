package com.ing.Soft.repositories;

import com.ing.Soft.dtos.CourseDto;
import com.ing.Soft.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
@Repository
public interface CourseRepository extends JpaRepository <Course, Integer> {

    Optional<Course> findById(Long id);
    Optional<Course> findByName(String name);

    @Query(value = "SELECT a.id, a.name, u.name as teacher, a.studentsNo, c.average " +
            "FROM course a " +
            "JOIN teacherenrollment te ON a.id = te.courseId " +
            "JOIN user u ON u.id = te.userId " +
            "JOIN feedbackaverage c ON a.id = c.courseId", nativeQuery = true)
    List<CourseDto> findCourseDtos();

    @Query(value = "SELECT a.id, a.name, u.name as teacher, a.studentsNo, c.average " +
            "FROM course a " +
            "JOIN teacherenrollment te ON a.id = te.courseId " +
            "JOIN user u ON u.id = te.userId " +
            "JOIN feedbackaverage c ON a.id = c.courseId " +
            "WHERE a.id = :id", nativeQuery = true)
    CourseDto findCourseDto(Long id);
}
