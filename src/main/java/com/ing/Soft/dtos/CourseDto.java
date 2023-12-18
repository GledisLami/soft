package com.ing.Soft.dtos;

import com.ing.Soft.interfaces.CourseInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto implements CourseInterface {
    Integer id;
    String name;
    String teacher;
    Integer studentsNo;
    Integer average;
}
