package com.example.edustream_courseMS.controller;

import com.example.edustream_courseMS.dto.requestDTO.RegisterSemesterRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.RequestSemesterById;
import com.example.edustream_courseMS.dto.responseDTO.ApiResponse;
import com.example.edustream_courseMS.dto.responseDTO.RegisterSemesterResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.SemesterRequestResponseDTO;
import com.example.edustream_courseMS.entity.Semester;
import com.example.edustream_courseMS.service.SemesterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/getById")
    public ResponseEntity<ApiResponse<SemesterRequestResponseDTO>> getSemesterById(
            @Valid @RequestBody RequestSemesterById requestSemesterById) {

        SemesterRequestResponseDTO responseDTO = semesterService.getSemesterByIdService(requestSemesterById);


        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.<SemesterRequestResponseDTO>builder()
                        .success(true)
                        .message("Semester retrieved successfully")
                        .data(responseDTO)
                        .build());


    }

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse<Page<Semester>>> getAllSemesters(Pageable pageable) {

        Page<Semester> responseDTO = semesterService.getAllSemestersService(pageable);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.<Page<Semester>>builder()
                        .success(true)
                        .message("Semesters retrieved successfully")
                        .data(responseDTO)
                        .build());
    }

}
