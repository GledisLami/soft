package com.ing.Soft.dtos;

import com.ing.Soft.interfaces.CourseInterface;
import lombok.Data;

@Data
public class CourseDto implements CourseInterface {
    private Integer id;
    private String name;
    private String teacher;
    private Integer studentsNo;
    private Integer average;

    public CourseDto(CourseInterface courseInterface) {
        this.id = courseInterface.getId();
        this.name = courseInterface.getName();
        this.teacher = courseInterface.getTeacher();
        this.studentsNo = courseInterface.getStudentsNo();
        this.average = courseInterface.getAverage();
    }

    public CourseDto() {
    }

    public CourseDto(Integer id, String name, String teacher, Integer studentsNo, Integer average) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.studentsNo = studentsNo;
        this.average = average;
    }
}
