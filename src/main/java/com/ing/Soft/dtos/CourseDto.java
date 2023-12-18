package com.ing.Soft.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    Long id;
    String name;
    String teacher;
    Integer studentsNo;
    Integer average;
}
