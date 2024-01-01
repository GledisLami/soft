package com.ing.Soft.repositories;

import com.ing.Soft.entities.StudentEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentEnrollmentRepository extends JpaRepository<StudentEnrollment, Integer> {




    @Query(value = "SELECT * FROM student_enrollment WHERE user_id = :user_id AND course_id = :course_id", nativeQuery = true)
    List<StudentEnrollment> findListByUserAndCourseId(Integer user_id, Integer course_id);


    @Query(value = "select * from student_enrollment where user_id = :user_id AND course_id = :course_id", nativeQuery = true)
    Optional<StudentEnrollment> findByUserAndCouseId(Integer user_id, Integer course_id);


}
