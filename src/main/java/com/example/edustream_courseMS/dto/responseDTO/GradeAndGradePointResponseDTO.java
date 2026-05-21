package com.example.edustream_courseMS.dto.responseDTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class GradeAndGradePointResponseDTO {

    private String grade;

    private  double gradePoint;
}
