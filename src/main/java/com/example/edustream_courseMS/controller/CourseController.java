package com.example.edustream_courseMS.controller;

import com.example.edustream_courseMS.dto.requestDTO.CourseRequestByCourseIdDTO;
import com.example.edustream_courseMS.dto.requestDTO.CourseRequestByUUIDDTO;
import com.example.edustream_lib_common.responseDTO.ApiResponse;
import com.example.edustream_courseMS.dto.requestDTO.RegisterCourseRequestDTO;
import com.example.edustream_courseMS.dto.responseDTO.PageResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.RegisterCourseResponseDTO;
import com.example.edustream_courseMS.entity.Course;
import com.example.edustream_courseMS.service.CourseService;
import com.example.edustream_courseMS.util.PageUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Course Controller", description = "API endpoints for managing courses, including registration, retrieval, and course enrollment.")
@SecurityRequirement(name = "bearerAuth")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/test")
    @Operation(summary = "Test Endpoint", description = "A simple endpoint to test if the CourseController is working properly.")
    public String testEndpoint() {

        return courseService.testService();
    }

    @PostMapping("/create")
    @Operation(summary = "Register a New Course", description = "Endpoint to create a new course. Accepts course details in the request body and returns the created course information.")
    public ResponseEntity<ApiResponse<RegisterCourseResponseDTO>> registerCourse(
            @Valid @RequestBody RegisterCourseRequestDTO registerCourseRequestDTO) {

        RegisterCourseResponseDTO response = courseService.registerCourse(registerCourseRequestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(response, "Course registered successfully"));

    }

    @PostMapping("/all")
    @Operation(summary = "Get All Courses with Pagination", description = "Endpoint to retrieve a paginated list of all courses. Accepts pagination parameters and returns a paginated response containing course information.")
    public ResponseEntity<ApiResponse<PageResponseDTO<Course>>> getAllCourses(Pageable pageable) {

        Page<Course> response = courseService.getAllCourses(pageable);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(PageUtil.toPageResponse(response), "Courses retrieved successfully"));
    }

    @PostMapping("/getCourseById")
    @Operation(summary = "Get Course by ID", description = "Endpoint to retrieve a course by its unique identifier (ID). Accepts the course ID in the request body and returns the corresponding course information.")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@RequestBody CourseRequestByCourseIdDTO request) {

        Course response = courseService.getCourseById(request.getCourseId());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(response, "Course retrieved successfully by course ID"));

    }

    @PostMapping("/getCourseByUUID")
    @Operation(summary = "Get Course by UUID", description = "Endpoint to retrieve a course by its universally unique identifier (UUID). Accepts the course UUID in the request body and returns the corresponding course information.")
    public ResponseEntity<ApiResponse<Course>> getCourseByUUID(@RequestBody CourseRequestByUUIDDTO request) {

        Course response = courseService.getCourseByUUID(request.getCourseUUID());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(response, "Course retrieved successfully by UUID"));

    }

    @PostMapping("/registerToCourse")
    @Operation(summary = "Register to a Course", description = "Endpoint to register a user to a course. Accepts the course ID in the request body and returns the UUID of the registered course enrollment.")
    public ResponseEntity<ApiResponse<UUID>> registerToCourse(@RequestBody CourseRequestByCourseIdDTO request) {

        UUID response = courseService.registerToCourse(request.getCourseId());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(response, "Course registration successful"));

    }

    @PostMapping("/registerToCourseCompensation")
    @Operation(summary = "Register to a Course with Compensation", description = "Endpoint to register a user to a course with compensation. Accepts the course UUID in the request body and returns a success message indicating that the course registration compensation was successful.")
    public ResponseEntity<ApiResponse<String>> registerToCourseCompensation(@RequestBody CourseRequestByUUIDDTO request) {

        String response = courseService.registerToCourseCompensation(request.getCourseUUID());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(response, "Course registration compensation successful"));

    }
}
