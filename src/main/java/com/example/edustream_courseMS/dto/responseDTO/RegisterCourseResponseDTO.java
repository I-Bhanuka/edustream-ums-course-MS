package com.example.edustream_courseMS.dto.requestDTO;

import com.example.edustream_courseMS.enums.CourseStatus;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterCourseResponseDTO {
    private String courseId;

    private String courseName;

    private int durationDays;

    private String badge;

    private int enrolledStudentsCount;

    private CourseStatus courseStatus;
}
