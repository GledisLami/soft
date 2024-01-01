package com.ing.Soft.dtos;

import com.ing.Soft.interfaces.CourseDetailedInterface;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class CourseDtoDetailed extends CourseDto {
    private String description;
    private String time;

    @Override
    public Integer getId() {
        return super.getId();
    }

    public CourseDtoDetailed(CourseDetailedInterface courseDetailedInterface) {
        super(new CourseDto(courseDetailedInterface.getId(), courseDetailedInterface.getName(),
                courseDetailedInterface.getTeacher(), courseDetailedInterface.getStudentsNo(),
                courseDetailedInterface.getAverage()));
        this.description = courseDetailedInterface.getDescription();
        this.time = courseDetailedInterface.getTime();
    }

    public CourseDtoDetailed() {
    }
}
