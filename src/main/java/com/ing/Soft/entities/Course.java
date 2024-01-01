package com.ing.Soft.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "course")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "time")
    private String time;

    @Column(name = "students_no")
    private Integer studentsNo;

    public Course(Integer id) {
        this.id = id;
    }

    public Course(Integer id, String name, String description, String time, Integer studentsNo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.time = time;
        this.studentsNo = studentsNo;
    }

    public Course() {
    }
}
