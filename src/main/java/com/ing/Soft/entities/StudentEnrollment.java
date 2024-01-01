package com.ing.Soft.entities;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student_enrollment")
@Data
public class StudentEnrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public StudentEnrollment(Course course, User user) {
        this.course = course;
        this.user = user;
    }

    public StudentEnrollment() {
    }
}
