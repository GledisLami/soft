package com.ing.Soft.dtos;

import com.ing.Soft.entities.Course;
import com.ing.Soft.entities.User;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter

public class FeedbackDto {

    private Integer rating;

    private String description;

    private Course course;

    private User user;

    private Date date;

    public FeedbackDto(Integer rating, String description, Course course, User user, Date date) {
        this.rating = rating;
        this.description = description;
        this.course = course;
        this.user = user;
        this.date = date;
    }

    public FeedbackDto() {
    }
}
