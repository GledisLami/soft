package com.ing.Soft.repositories;

import com.ing.Soft.entities.TeacherEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherEnrollmentRepository extends JpaRepository<TeacherEnrollment, Long> {
}
