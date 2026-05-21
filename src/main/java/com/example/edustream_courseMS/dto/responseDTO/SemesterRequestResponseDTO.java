package com.example.edustream_courseMS.dto.responseDTO;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class SemesterRequestResponseDTO {

    private String name;

    private int year;

    private int semesterNo;

    private LocalDate startDate;

    private LocalDate endDate;
}
