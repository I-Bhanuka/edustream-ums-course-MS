package com.example.edustream_courseMS.controller;

import com.example.edustream_courseMS.dto.requestDTO.EnrollStudentToModuleRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.RequestModuleEnrollmentById;
import com.example.edustream_courseMS.dto.responseDTO.ApiResponse;
import com.example.edustream_courseMS.dto.responseDTO.EnrollStudentToModuleResponseDTO;
import com.example.edustream_courseMS.entity.StudentModule;
import com.example.edustream_courseMS.service.StudentModuleService;
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
public class StudentModuleController {

    private final StudentModuleService studentModuleService;

    @PostMapping("/enrollStudentInModule")
    public ResponseEntity<ApiResponse<EnrollStudentToModuleResponseDTO>> enrollStudentInModule(
            @Valid @RequestBody EnrollStudentToModuleRequestDTO enrollStudentToModuleRequestDTO) {

        EnrollStudentToModuleResponseDTO responseDTO = studentModuleService.enrollStudentInModuleService(enrollStudentToModuleRequestDTO);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.<EnrollStudentToModuleResponseDTO>builder()
                        .success(true)
                        .message("Student enrolled in module successfully")
                        .data(responseDTO)
                        .build());
    }

    @PostMapping("/getById")
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
