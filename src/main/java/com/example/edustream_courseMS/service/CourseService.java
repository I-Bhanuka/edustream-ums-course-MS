package com.example.edustream_courseMS.service;

import com.example.edustream_courseMS.dto.requestDTO.RegisterCourseRequestDTO;
import com.example.edustream_courseMS.dto.responseDTO.RegisterCourseResponseDTO;
import com.example.edustream_courseMS.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CourseService {
    String testService();

    RegisterCourseResponseDTO registerCourse(RegisterCourseRequestDTO registerCourseRequestDTO);

    Page<Course> getAllCourses(Pageable pageable);

    Course getCourseById(String courseId);

    Course getCourseByUUID(UUID courseUUID);

    UUID registerToCourse(String courseId);

    String registerToCourseCompensation(UUID courseUUID);
}
