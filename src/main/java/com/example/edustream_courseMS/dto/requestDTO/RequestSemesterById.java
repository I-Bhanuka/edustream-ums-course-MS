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
public class RequestSemesterById {

    @NotNull(message = "semester ID is required")
    private UUID semesterId;
}
