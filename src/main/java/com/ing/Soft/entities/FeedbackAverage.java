package com.ing.Soft.entities;

import javax.persistence.*;
import lombok.Data;
@Entity
@Table(name = "feedback_average")
@Data
public class FeedbackAverage {

    @Id
    private Integer courseId;

    @Column(name = "average")
    private Integer average;


}
