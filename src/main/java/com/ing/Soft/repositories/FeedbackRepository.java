package com.ing.Soft.repositories;

import com.ing.Soft.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.sql.Date;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

    @Query(value = "SELECT * FROM feedback WHERE date < :date", nativeQuery = true)
    List<Feedback> findByDateBefore(Date date);

    @Query(value = "SELECT * FROM feedback WHERE course_id = :courseId ORDER BY date DESC", nativeQuery = true)
    List<Feedback> findByCourseId(Integer courseId);

    Optional<Feedback> findByUser_Id(Integer userId);

    @Query(value = "SELECT * from feedback where course_id = :course_id and user_id = :user_id", nativeQuery = true)
    Optional<Feedback> findByUserAndCourseId(Integer course_id, Integer user_id);

    // Using a custom query with @Query
    @Query(value = "SELECT * FROM feedback WHERE user_id = :userId", nativeQuery = true)
    Optional<Feedback> findFeedbackByUserId(Integer userId);

}
