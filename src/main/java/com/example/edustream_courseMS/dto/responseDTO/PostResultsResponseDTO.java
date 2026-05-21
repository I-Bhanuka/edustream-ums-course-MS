package com.example.edustream_courseMS.dto.responseDTO;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class PostResultsResponseDTO {

    private UUID enrollmentId;

    private double mark;

    private String grade;

    private double gradePoint;

}
