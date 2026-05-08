package com.example.edustream_courseMS.service;

import com.example.edustream_courseMS.dto.requestDTO.RegisterCourseRequestDTO;
import com.example.edustream_courseMS.dto.responseDTO.RegisterCourseResponseDTO;

public interface CourseService {
    String testService();

    RegisterCourseResponseDTO registerCourse(RegisterCourseRequestDTO registerCourseRequestDTO);
}
