package com.example.edustream_courseMS.controller;

import com.example.edustream_courseMS.dto.requestDTO.RegisterCourseRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.RegisterGradeScaleRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.RequestGradeScaleByGrade;
import com.example.edustream_courseMS.dto.responseDTO.ApiResponse;
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

        return ResponseEntity.status(HttpStatus.CREATED).
                body(ApiResponse.<RegisterGradeScaleResponseDTO>builder()
                        .success(true)
                        .message("Grade scale registered successfully")
                        .data(responseDTO)
                        .build());
    }


    @PostMapping("/getByGrade")
    public ResponseEntity<ApiResponse<GradeScaleRequestResponseDTO>> getGradeScaleByGrade(
            @Valid @RequestBody RequestGradeScaleByGrade requestGradeScaleByGrade) {

        GradeScaleRequestResponseDTO responseDTO = gradeScaleService.getGradeScaleByGradeService(requestGradeScaleByGrade);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.<GradeScaleRequestResponseDTO>builder()
                        .success(true)
                        .message("Grade scale retrieved successfully gy grade: " + requestGradeScaleByGrade.getGrade())
                        .data(responseDTO)
                        .build());
    }

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse<Page<GradeScale>>> getAllGradeScales(Pageable pageable) {

        Page<GradeScale> responseDTO = gradeScaleService.getAllGradeScalesService(pageable);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.<Page<GradeScale>>builder()
                        .success(true)
                        .message("Grade scales retrieved successfully")
                        .data(responseDTO)
                        .build());
    }
}
