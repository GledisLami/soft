package com.ing.Soft.repositories;

import com.ing.Soft.entities.StudentEnrollment;
import com.ing.Soft.interfaces.CourseInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentEnrollmentRepository extends JpaRepository<StudentEnrollment, Integer> {

    @Query(value = "SELECT a.id as id, a.name as name, u.name as teacher, a.students_no as studentsNo, c.average as average " +
            "FROM course a " +
            "JOIN teacher_enrollment te ON a.id = te.course_id " +
            "JOIN user u ON u.id = te.user_id " +
            "JOIN feedback_average c ON a.id = c.course_id"+
            "JOIN student enrollment se ON se.user_id =:user_id", nativeQuery = true)
    List<CourseInterface> findCourseDtosByUserId(Integer user_id);

    @Query(value = "SELECT * FROM student_enrollment WHERE user_id = :user_id AND course_id = :course_id", nativeQuery = true)
    StudentEnrollment findByStudentAndCourseId(Integer user_id, Integer course_id);


}
