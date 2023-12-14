package com.ing.Soft.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "feedback")
@Data
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "courseId", referencedColumnName = "id")
    private Course course;
}
