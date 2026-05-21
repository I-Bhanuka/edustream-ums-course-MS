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
public class PostResultsRequestDTO {

    @NotNull(message = "enrollment UUID is required")
    private UUID enrollmentId;

    @NotNull(message = "mark is required")
    private double mark;
}
