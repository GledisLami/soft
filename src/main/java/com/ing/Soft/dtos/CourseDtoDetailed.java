package com.ing.Soft.dtos;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
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
}
