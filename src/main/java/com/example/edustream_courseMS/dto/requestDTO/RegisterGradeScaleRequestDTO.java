package com.example.edustream_courseMS.dto.requestDTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RegisterGradeScaleRequestDTO {

    private String grade;

    private double min;

    private double max;

    private double gradePoint;
}
