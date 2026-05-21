package com.example.edustream_courseMS.dto.requestDTO;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RequestModuleEnrollmentById {

    @NotNull(message = "Enrollment ID is required")
    private UUID enrollmentId;
}
