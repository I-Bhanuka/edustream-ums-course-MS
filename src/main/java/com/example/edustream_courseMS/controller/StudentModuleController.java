package com.example.edustream_courseMS.controller;

import com.example.edustream_courseMS.dto.requestDTO.EnrollStudentToModuleRequestDTO;
import com.example.edustream_courseMS.dto.responseDTO.ApiResponse;
import com.example.edustream_courseMS.dto.responseDTO.EnrollStudentToModuleResponseDTO;
import com.example.edustream_courseMS.service.StudentModuleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
