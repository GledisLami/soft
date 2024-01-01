package com.ing.Soft.repositories;

import com.ing.Soft.entities.Course;
import com.ing.Soft.interfaces.CourseDetailedInterface;
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


    @Query(value = "SELECT a.id as id, a.name as name, u.name as teacher, a.students_no as studentsNo, fa.average as average " +
            "FROM course a " +
            "JOIN feedback_average fa ON fa.course_id = a.id " +
            "JOIN teacher_enrollment te ON te.course_id = a.id " +
            "JOIN user u ON u.id = te.user_id " +
            "ORDER BY fa.average DESC LIMIT 8", nativeQuery = true)
    List<CourseInterface> findTop8ByOrderByAverageDesc();

    @Query(value = "SELECT a.id as id, a.name as name, u.name as teacher, a.students_no as studentsNo, c.average as average " +
            "FROM course a " +
            "JOIN teacher_enrollment te ON a.id = te.course_id " +
            "JOIN user u ON u.id = te.user_id " +
            "JOIN feedback_average c ON a.id = c.course_id " +
            "JOIN student_enrollment se ON se.user_id =:user_id AND se.course_id = a.id", nativeQuery = true)
    List<CourseInterface> findCourseDtosByUserId(Integer user_id);


    @Query(value = "SELECT a.id AS id, a.name AS name, a.description AS description, a.time AS time, a.students_no AS studentsNo, a.location AS location, fa.average AS average, u.name AS teacher " +
            "FROM course a " +
            "JOIN feedback_average fa ON fa.course_id = a.id " +
            "JOIN teacher_enrollment te ON te.course_id = a.id " +
            "JOIN user u ON u.id = te.user_id " +
            "WHERE a.id = :id", nativeQuery = true)
    CourseDetailedInterface findCourseDtoDetailed(Integer id);

    @Query(value = "SELECT a.id AS id, a.name AS name, a.description AS description, a.time AS time, a.students_no AS studentsNo, a.location AS location, fa.average AS average, u.name AS teacher " +
            "FROM course a " +
            "JOIN feedback_average fa ON fa.course_id = a.id " +
            "JOIN teacher_enrollment te ON te.course_id = a.id " +
            "JOIN user u ON u.id = te.user_id", nativeQuery = true)
    List<CourseDetailedInterface> findAllCourseDtoDetailed();

}
