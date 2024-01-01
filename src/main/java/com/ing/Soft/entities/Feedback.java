package com.ing.Soft.entities;

import com.ing.Soft.dtos.FeedbackDto;
import javax.persistence.*;
import lombok.Data;

import java.sql.Date;

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

    public Feedback(FeedbackDto feedbackDto) {
        this.rating = feedbackDto.getRating();
        this.description = feedbackDto.getDescription();
        this.course = new Course(feedbackDto.getCourseId());
        this.user = new User(feedbackDto.getUserId());
        this.date = feedbackDto.getDate();
    }

    public static Feedback fromDTO(FeedbackDto feedbackDTO) {
        Feedback feedback = new Feedback();
        feedback.setRating(feedbackDTO.getRating());
        feedback.setDescription(feedbackDTO.getDescription());
        feedback.setCourse(new Course(feedbackDTO.getCourseId()));
        feedback.setUser(new User(feedbackDTO.getUserId()));
        feedback.setDate(feedbackDTO.getDate());
        return feedback;
    }

    public Feedback() {
    }

}
