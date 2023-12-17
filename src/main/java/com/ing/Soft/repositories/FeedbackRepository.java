package com.ing.Soft.repositories;

import com.ing.Soft.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.sql.Date;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Query(value = "SELECT * FROM feedback WHERE date < :date", nativeQuery = true)
    List<Feedback> findByDateBefore(Date date);

    @Query(value = "SELECT * FROM feedback WHERE courseId = :courseId ORDER BY date DESC", nativeQuery = true)
    List<Feedback> findByCourseId(Long courseId);

}
