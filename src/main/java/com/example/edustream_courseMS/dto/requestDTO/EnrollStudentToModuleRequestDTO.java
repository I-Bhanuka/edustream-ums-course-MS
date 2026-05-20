package com.example.edustream_courseMS.dto.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class EnrollStudentToModuleRequestDTO {

    @NotNull(message = "student id is required")
    private UUID studentId;

    @NotNull(message = "module id is required")
    private UUID moduleId;

    @NotNull(message = "semester id is required")
    private UUID semesterId;
}
