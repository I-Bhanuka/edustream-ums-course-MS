package com.example.edustream_courseMS.dto.requestDTO;

import jakarta.persistence.Column;
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
public class RegisterSemesterRequestDTO {

    @NotNull(message = "semester name is required")
    @NotBlank(message = "semester name cannot be blank")
    private String name;

    @NotNull(message = "year is required")
    private int year;

    @NotNull(message = "semester number is required")
    private int semesterNo;

    @NotNull(message = "start date is required")
    private LocalDate startDate;

    @NotNull(message = "end date is required")
    private LocalDate endDate;
}
