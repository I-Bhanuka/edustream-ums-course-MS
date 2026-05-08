package com.example.edustream_courseMS.dto.requestDTO;

import com.example.edustream_courseMS.enums.CourseStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterCourseRequestDTO {

    @NotBlank(message = "Course ID is required")
    private String courseId;

    @NotBlank(message = "Course Name is required")
    private String courseName;

    @NotNull(message = "Duration in days is required")
    private int durationDays;

    @NotBlank(message = "Badge is required")
    private String badge;

}
