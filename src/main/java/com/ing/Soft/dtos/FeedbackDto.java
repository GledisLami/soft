package com.ing.Soft.dtos;

import com.ing.Soft.entities.Course;
import com.ing.Soft.entities.Feedback;
import com.ing.Soft.entities.User;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter

public class FeedbackDto {

    private Integer rating;

    private String description;

    private Integer courseId;

    private Integer userId;

    private Date date;

    public FeedbackDto(Feedback feedback) {
        this.rating = feedback.getRating();
        this.description = feedback.getDescription();
        this.courseId = feedback.getCourse().getId();
        this.userId = feedback.getUser().getId();
        this.date = feedback.getDate();
    }

    public FeedbackDto() {
    }
}
