package com.ing.Soft.dtos;

import com.ing.Soft.entities.Feedback;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter

public class FeedbackDto {

    private Integer rating;

    private String description;

    private Integer courseId;

    private String courseName;

    private Integer userId;

    private Date date;

    public FeedbackDto(Feedback feedback) {
        this.rating = feedback.getRating();
        this.description = feedback.getDescription();
        this.courseId = feedback.getCourse().getId();
        this.courseName = feedback.getCourse().getName();
        this.userId = feedback.getUser().getId();
        this.date = feedback.getDate();
    }

    public FeedbackDto() {
    }
}
