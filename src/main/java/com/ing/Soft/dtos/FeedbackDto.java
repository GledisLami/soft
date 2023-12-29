package com.ing.Soft.dtos;

import com.ing.Soft.entities.Course;
import com.ing.Soft.entities.User;

import java.sql.Date;

public class FeedbackDto {

    private Integer rating;

    private String description;

    private Course course;

    private User user;

    private Date date;

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
