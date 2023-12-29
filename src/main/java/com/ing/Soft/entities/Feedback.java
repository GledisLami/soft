package com.ing.Soft.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Optional;

@Entity
@Table(name = "feedback")
@Data
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    //sql date
    @Column(name = "date")
    private Date date;


}
