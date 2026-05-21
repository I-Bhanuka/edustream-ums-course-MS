package com.example.edustream_courseMS.dto.responseDTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class GradeScaleRequestResponseDTO {

    private String grade;

    private double min;

    private double max;

    private double gradePoint;
}
