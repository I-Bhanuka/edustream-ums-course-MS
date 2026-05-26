package com.example.edustream_courseMS.controller;

import com.example.edustream_courseMS.dto.requestDTO.RegisterGradeScaleRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.RequestGradeScaleByGrade;
import com.example.edustream_lib_common.responseDTO.ApiResponse;
import com.example.edustream_courseMS.dto.responseDTO.GradeScaleRequestResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.RegisterGradeScaleResponseDTO;
import com.example.edustream_courseMS.entity.GradeScale;
import com.example.edustream_courseMS.service.GradeScaleService;
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
public class GradeScaleController {

    private final GradeScaleService gradeScaleService;

    @PostMapping("/registerScale")
    public ResponseEntity<ApiResponse<RegisterGradeScaleResponseDTO>> registerScale(
            @RequestBody RegisterGradeScaleRequestDTO registerGradeScaleRequestDTO) {

        RegisterGradeScaleResponseDTO responseDTO = gradeScaleService.registerGradeScaleService(registerGradeScaleRequestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(responseDTO, "Grade scale registered successfully"));

    }


    @PostMapping("/getByGrade")
    public ResponseEntity<ApiResponse<GradeScaleRequestResponseDTO>> getGradeScaleByGrade(
            @Valid @RequestBody RequestGradeScaleByGrade requestGradeScaleByGrade) {

        GradeScaleRequestResponseDTO responseDTO = gradeScaleService.getGradeScaleByGradeService(requestGradeScaleByGrade);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(responseDTO, "Grade scale retrieved successfully gy grade: " + requestGradeScaleByGrade.getGrade()));

    }

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse<Page<GradeScale>>> getAllGradeScales(Pageable pageable) {

        Page<GradeScale> responseDTO = gradeScaleService.getAllGradeScalesService(pageable);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(responseDTO, "Grade scales retrieved successfully"));

    }
}
