package com.example.edustream_courseMS.controller;

import com.example.edustream_courseMS.dto.requestDTO.RegisterSemesterRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.RequestSemesterById;
import com.example.edustream_lib_common.responseDTO.ApiResponse;
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

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(responseDTO, "Semester registered successfully"));

    }

    @PostMapping("/getById")
    public ResponseEntity<ApiResponse<SemesterRequestResponseDTO>> getSemesterById(
            @Valid @RequestBody RequestSemesterById requestSemesterById) {

        SemesterRequestResponseDTO responseDTO = semesterService.getSemesterByIdService(requestSemesterById);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(responseDTO, "Semester retrieved successfully"));

    }

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse<Page<Semester>>> getAllSemesters(Pageable pageable) {

        Page<Semester> responseDTO = semesterService.getAllSemestersService(pageable);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(responseDTO, "Semesters retrieved successfully"));

    }

}
