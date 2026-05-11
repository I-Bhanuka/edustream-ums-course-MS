package com.example.edustream_courseMS.dto.requestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseRequestDTO {

    @NotBlank(message = "courseId is required")
    private  String courseId;
}
