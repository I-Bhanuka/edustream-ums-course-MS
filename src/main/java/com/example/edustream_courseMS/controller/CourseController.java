package com.example.edustream_courseMS.controller;

import com.example.edustream_courseMS.dto.responseDTO.ApiResponse;
import com.example.edustream_courseMS.dto.requestDTO.RegisterCourseRequestDTO;
import com.example.edustream_courseMS.dto.responseDTO.RegisterCourseResponseDTO;
import com.example.edustream_courseMS.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/test")
    public String testEndpoint() {

        return courseService.testService();
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<RegisterCourseResponseDTO>> registerStudent(
            @Valid @RequestBody RegisterCourseRequestDTO registerCourseRequestDTO) {

        RegisterCourseResponseDTO response = courseService.registerCourse(registerCourseRequestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.<RegisterCourseResponseDTO>builder()
                        .success(true)
                        .message("Course registered successfully")
                        .data(response)
                        .build());
    }
}
