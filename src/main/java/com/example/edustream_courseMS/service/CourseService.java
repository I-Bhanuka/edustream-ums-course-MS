package com.example.edustream_courseMS.service;

import com.example.edustream_courseMS.dto.requestDTO.CourseRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.RegisterCourseRequestDTO;
import com.example.edustream_courseMS.dto.responseDTO.RegisterCourseResponseDTO;
import com.example.edustream_courseMS.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {
    String testService();

    RegisterCourseResponseDTO registerCourse(RegisterCourseRequestDTO registerCourseRequestDTO);

    Page<Course> getAllCourses(Pageable pageable);

    Course getCourseById(String courseId);
}
