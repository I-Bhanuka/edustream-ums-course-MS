package com.example.edustream_courseMS.controller;

import com.example.edustream_courseMS.dto.requestDTO.RegisterEnrollStudentToModuleRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.RequestModuleEnrollmentById;
import com.example.edustream_lib_common.responseDTO.ApiResponse;
import com.example.edustream_courseMS.dto.responseDTO.EnrollStudentToModuleResponseDTO;
import com.example.edustream_courseMS.entity.StudentModule;
import com.example.edustream_courseMS.service.StudentModuleService;
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

@RestController
@RequestMapping("/api/StudentModule")
@RequiredArgsConstructor
@Tag(name = "Student Module Controller", description = "API endpoints for managing student enrollments in modules, including enrollment, retrieval by ID, and retrieval of all enrollments with pagination.")
@SecurityRequirement(name = "bearerAuth")
public class StudentModuleController {

    private final StudentModuleService studentModuleService;

    @PostMapping("/enrollStudentInModule")
    @Operation(summary = "Enroll Student in Module", description = "Endpoint to enroll a student in a module. Accepts enrollment details in the request body and returns the enrollment information.")
    public ResponseEntity<ApiResponse<EnrollStudentToModuleResponseDTO>> enrollStudentInModule(
            @Valid @RequestBody RegisterEnrollStudentToModuleRequestDTO registerEnrollStudentToModuleRequestDTO) {

        EnrollStudentToModuleResponseDTO responseDTO = studentModuleService.enrollStudentInModuleService(registerEnrollStudentToModuleRequestDTO);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.<EnrollStudentToModuleResponseDTO>builder()
                        .success(true)
                        .message("Student enrolled in module successfully")
                        .data(responseDTO)
                        .build());
    }

    @PostMapping("/getById")
    @Operation(summary = "Get Enrollment by ID", description = "Endpoint to retrieve a student enrollment based on the provided enrollment ID. Accepts a request body containing the enrollment ID and returns the corresponding enrollment information.")
    public ResponseEntity<ApiResponse<EnrollStudentToModuleResponseDTO>> getEnrollmentByd(
            @Valid @RequestBody RequestModuleEnrollmentById requestModuleEnrollmentById) {

        EnrollStudentToModuleResponseDTO responseDTO = studentModuleService.getEnrollmentByIdService(requestModuleEnrollmentById);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.<EnrollStudentToModuleResponseDTO>builder()
                        .success(true)
                        .message("Enrollment retrieved successfully")
                        .data(responseDTO)
                        .build());
    }


    @GetMapping("/getAll")

    @Operation(summary = "Get All Enrollments with Pagination", description = "Endpoint to retrieve a paginated list of all student enrollments. Accepts pagination parameters and returns a paginated response containing enrollment information.")
    public ResponseEntity<ApiResponse<Page<StudentModule>>> getAllEnrollments(Pageable pageable) {

        Page<StudentModule> responseDTO = studentModuleService.getAllEnrollmentsService(pageable);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.<Page<StudentModule>>builder()
                        .success(true)
                        .message("All enrollments retrieved successfully")
                        .data(responseDTO)
                        .build());
    }
}
