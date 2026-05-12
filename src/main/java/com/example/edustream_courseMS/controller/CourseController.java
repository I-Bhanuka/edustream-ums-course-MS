package com.example.edustream_courseMS.controller;

import com.example.edustream_courseMS.dto.requestDTO.CourseRequestByCourseIdDTO;
import com.example.edustream_courseMS.dto.requestDTO.CourseRequestByUUIDDTO;
import com.example.edustream_courseMS.dto.responseDTO.ApiResponse;
import com.example.edustream_courseMS.dto.requestDTO.RegisterCourseRequestDTO;
import com.example.edustream_courseMS.dto.responseDTO.PageResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.RegisterCourseResponseDTO;
import com.example.edustream_courseMS.entity.Course;
import com.example.edustream_courseMS.service.CourseService;
import com.example.edustream_courseMS.util.PageUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    public ResponseEntity<ApiResponse<RegisterCourseResponseDTO>> registerCourse(
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

    @PostMapping("/all")
    public ResponseEntity<ApiResponse<PageResponseDTO<Course>>> getAllCourses(Pageable pageable) {

        Page<Course> response = courseService.getAllCourses(pageable);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.<PageResponseDTO<Course>>builder()
                        .success(true)
                        .message("Courses retrieved successfully")
                        .data(PageUtil.toPageResponse(response))
                        .build());
    }

    @PostMapping("/getCourseById")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@RequestBody CourseRequestByCourseIdDTO request) {

        Course response = courseService.getCourseById(request.getCourseId());

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.<Course>builder()
                        .success(true)
                        .message("Course retrieved successfully by course ID")
                        .data(response)
                        .build());
    }

    @PostMapping("/getCourseByUUID")
    public ResponseEntity<ApiResponse<Course>> getCourseByUUID(@RequestBody CourseRequestByUUIDDTO request) {

        Course response = courseService.getCourseByUUID(request.getCourseUUID());

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.<Course>builder()
                        .success(true)
                        .message("Course retrieved successfully by UUID")
                        .data(response)
                        .build());
    }

    @PostMapping("/registerToCourse")
    public ResponseEntity<ApiResponse<UUID>> registerToCourse(@RequestBody CourseRequestByCourseIdDTO request) {

        UUID response = courseService.registerToCourse(request.getCourseId());


        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.<UUID>builder()
                        .success(true)
                        .message("Course registration successful")
                        .data(response)
                        .build());
    }

}
