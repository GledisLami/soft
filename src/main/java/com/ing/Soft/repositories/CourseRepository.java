package com.ing.Soft.repositories;

import com.ing.Soft.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAllCourseByStudentsNo(Integer studentNo);
}
