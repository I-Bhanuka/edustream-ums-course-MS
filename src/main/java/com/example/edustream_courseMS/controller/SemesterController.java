package com.example.edustream_courseMS.controller;

import com.example.edustream_courseMS.dto.requestDTO.RegisterSemesterRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.RequestSemesterById;
import com.example.edustream_lib_common.responseDTO.ApiResponse;
import com.example.edustream_courseMS.dto.responseDTO.RegisterSemesterResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.SemesterRequestResponseDTO;
import com.example.edustream_courseMS.entity.Semester;
import com.example.edustream_courseMS.service.SemesterService;
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
@RequestMapping("/api/semester")
@RequiredArgsConstructor
@Tag(name = "Semester Controller", description = "API endpoints for managing semesters, including registration, retrieval by ID, and retrieval of all semesters with pagination.")
@SecurityRequirement(name = "bearerAuth")
public class SemesterController {

    private final SemesterService semesterService;

    @PostMapping("/register")
    @Operation(summary = "Register a New Semester", description = "Endpoint to create a new semester. Accepts semester details in the request body and returns the created semester information.")
    public ResponseEntity<ApiResponse<RegisterSemesterResponseDTO>> registerSemester(
            @Valid @RequestBody RegisterSemesterRequestDTO registerSemesterRequestDTO) {

        RegisterSemesterResponseDTO responseDTO = semesterService.registerSemesterService(registerSemesterRequestDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(responseDTO, "Semester registered successfully"));

    }

    @PostMapping("/getById")
    @Operation(summary = "Get Semester by ID", description = "Endpoint to retrieve a semester based on the provided semester ID. Accepts a request body containing the semester ID and returns the corresponding semester information.")
    public ResponseEntity<ApiResponse<SemesterRequestResponseDTO>> getSemesterById(
            @Valid @RequestBody RequestSemesterById requestSemesterById) {

        SemesterRequestResponseDTO responseDTO = semesterService.getSemesterByIdService(requestSemesterById);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(responseDTO, "Semester retrieved successfully"));

    }

    @GetMapping("/getAll")
    @Operation(summary = "Get All Semesters with Pagination", description = "Endpoint to retrieve a paginated list of all semesters. Accepts pagination parameters and returns a paginated response containing semester information.")
    public ResponseEntity<ApiResponse<Page<Semester>>> getAllSemesters(Pageable pageable) {

        Page<Semester> responseDTO = semesterService.getAllSemestersService(pageable);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(responseDTO, "Semesters retrieved successfully"));

    }

}
