package com.ing.Soft.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "teacherEnrollment")
@Data
public class TeacherEnrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "courseId", referencedColumnName = "id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

}
