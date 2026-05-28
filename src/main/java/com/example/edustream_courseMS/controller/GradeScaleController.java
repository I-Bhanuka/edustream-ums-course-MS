package com.example.edustream_courseMS.controller;

import com.example.edustream_courseMS.dto.requestDTO.RegisterGradeScaleRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.RequestGradeScaleByGrade;
import com.example.edustream_lib_common.responseDTO.ApiResponse;
import com.example.edustream_courseMS.dto.responseDTO.GradeScaleRequestResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.RegisterGradeScaleResponseDTO;
import com.example.edustream_courseMS.entity.GradeScale;
import com.example.edustream_courseMS.service.GradeScaleService;
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
@RequestMapping("/api/grade-scale")
@RequiredArgsConstructor
@Tag(name = "Grade Scale Controller", description = "API endpoints for managing grade scales, including registration and retrieval of grade scales based on grade or pagination.")
@SecurityRequirement(name = "bearerAuth")
public class GradeScaleController {

    private final GradeScaleService gradeScaleService;

    @PostMapping("/registerScale")
    @Operation(summary = "Register a New Grade Scale", description = "Endpoint to create a new grade scale. Accepts grade scale details in the request body and returns the created grade scale information.")
    public ResponseEntity<ApiResponse<RegisterGradeScaleResponseDTO>> registerScale(
            @RequestBody RegisterGradeScaleRequestDTO registerGradeScaleRequestDTO) {

        RegisterGradeScaleResponseDTO responseDTO = gradeScaleService.registerGradeScaleService(registerGradeScaleRequestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(responseDTO, "Grade scale registered successfully"));

    }


    @PostMapping("/getByGrade")
    @Operation(summary = "Get Grade Scale by Grade", description = "Endpoint to retrieve a grade scale based on the provided grade. Accepts a request body containing the grade and returns the corresponding grade scale information.")
    public ResponseEntity<ApiResponse<GradeScaleRequestResponseDTO>> getGradeScaleByGrade(
            @Valid @RequestBody RequestGradeScaleByGrade requestGradeScaleByGrade) {

        GradeScaleRequestResponseDTO responseDTO = gradeScaleService.getGradeScaleByGradeService(requestGradeScaleByGrade);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(responseDTO, "Grade scale retrieved successfully gy grade: " + requestGradeScaleByGrade.getGrade()));

    }

    @GetMapping("/getAll")
    @Operation(summary = "Get All Grade Scales with Pagination", description = "Endpoint to retrieve a paginated list of all grade scales. Accepts pagination parameters and returns a paginated response containing grade scale information.")
    public ResponseEntity<ApiResponse<Page<GradeScale>>> getAllGradeScales(Pageable pageable) {

        Page<GradeScale> responseDTO = gradeScaleService.getAllGradeScalesService(pageable);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(responseDTO, "Grade scales retrieved successfully"));

    }
}
