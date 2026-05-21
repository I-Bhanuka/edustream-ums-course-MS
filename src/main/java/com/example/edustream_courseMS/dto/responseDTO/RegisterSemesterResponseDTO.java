package com.example.edustream_courseMS.dto.responseDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RegisterSemesterResponseDTO {

    private String name;

    private int year;

    private int semesterNo;

    private LocalDate startDate;

    private LocalDate endDate;
}
