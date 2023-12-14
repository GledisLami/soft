package com.ing.Soft.entities;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "feedbackAverage")
@Data
public class FeedbackAverage {

    @Column(name = "average")
    private Integer average;

    @Id
    private Integer courseId;

}
