package com.ing.Soft.repositories;

import com.ing.Soft.entities.StudentEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentEnrollmentRepository extends JpaRepository<StudentEnrollment, Integer> {
    void enrollStudent(StudentEnrollment enrollment);
    void unenrollment(Integer studentId);
    List<StudentEnrollment> getEnrolledCoursesForStudents(Integer studentId);


}
