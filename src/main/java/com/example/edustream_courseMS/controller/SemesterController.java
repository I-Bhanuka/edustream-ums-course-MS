package com.example.edustream_courseMS.controller;

import com.example.edustream_courseMS.dto.requestDTO.RegisterSemesterRequestDTO;
import com.example.edustream_courseMS.dto.responseDTO.ApiResponse;
import com.example.edustream_courseMS.dto.responseDTO.RegisterSemesterResponseDTO;
import com.example.edustream_courseMS.service.SemesterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/semester")
@RequiredArgsConstructor
public class SemesterController {

    private final SemesterService semesterService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<RegisterSemesterResponseDTO>> registerSemester(
            @Valid @RequestBody RegisterSemesterRequestDTO registerSemesterRequestDTO) {

        RegisterSemesterResponseDTO responseDTO = semesterService.registerSemesterService(registerSemesterRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.<RegisterSemesterResponseDTO>builder()
                        .success(true)
                        .message("Semester registered successfully")
                        .data(responseDTO)
                        .build());
    }

}
