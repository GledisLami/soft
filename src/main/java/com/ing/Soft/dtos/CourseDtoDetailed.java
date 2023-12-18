package com.ing.Soft.dtos;

import com.ing.Soft.entities.Feedback;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class CourseDtoDetailed extends CourseDto{
    private String description;
    private String time;
}
