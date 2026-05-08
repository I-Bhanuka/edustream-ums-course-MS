package com.example.edustream_courseMS.dto.responseDTO;

import com.example.edustream_courseMS.enums.CourseStatus;
import lombok.*;

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
