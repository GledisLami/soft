package com.ing.Soft.repositories;
import com.ing.Soft.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface CourseRepository extends JpaRepository <Course, Integer> {

    Optional<Course> findById(Integer id);
    Optional<Course> findByName(String name);

}
