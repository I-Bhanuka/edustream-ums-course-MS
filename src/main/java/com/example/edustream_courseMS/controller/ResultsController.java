package com.example.edustream_courseMS.controller;

import com.example.edustream_courseMS.dto.requestDTO.PostResultsRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.ResultsRequestByEnrollmentIdDTO;
import com.example.edustream_lib_common.responseDTO.ApiResponse;
import com.example.edustream_courseMS.dto.responseDTO.PostResultsResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.ResultsByEnrollmentResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.ResultsResponseDTO;
import com.example.edustream_courseMS.service.ResultsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/results")
@RequiredArgsConstructor
public class ResultsController {

    private final ResultsService resultsService;

    @PostMapping("/postResults")
    public ResponseEntity<ApiResponse<PostResultsResponseDTO>> postResults(
            @Valid @RequestBody PostResultsRequestDTO postResultsRequestDTO) {

        PostResultsResponseDTO response = resultsService.postResultsService(postResultsRequestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(response, "Result posted successfully"));

    }

    @PostMapping("/getResultsByEnrollmentId")
    public ResponseEntity<ApiResponse<ResultsByEnrollmentResponseDTO>> getResultsByEnrollmentId(
            @Valid @RequestBody ResultsRequestByEnrollmentIdDTO resultsRequestByEnrollmentIdDTO) {

        ResultsByEnrollmentResponseDTO response = resultsService.getResultsByEnrollmentIdService(resultsRequestByEnrollmentIdDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(response, "Result retrieved successfully for enrollment ID: " + resultsRequestByEnrollmentIdDTO.getEnrollmentId()));

    }

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse<Page<ResultsResponseDTO>>> getAllResults(Pageable pageable) {

        Page<ResultsResponseDTO> response = resultsService.getAllResultsService(pageable);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(response, "All results retrieved successfully"));

    }
}
