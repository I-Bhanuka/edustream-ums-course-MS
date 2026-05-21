package com.example.edustream_courseMS.controller;

import com.example.edustream_courseMS.dto.requestDTO.PostResultsRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.ResultsRequestByEnrollmentIdDTO;
import com.example.edustream_courseMS.dto.responseDTO.ApiResponse;
import com.example.edustream_courseMS.dto.responseDTO.PostResultsResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.ResultsByEnrollmentResponseDTO;
import com.example.edustream_courseMS.service.ResultsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/results")
@RequiredArgsConstructor
public class ResultsController {

    private final ResultsService resultsService;

    @PostMapping("/postResults")
    public ResponseEntity<ApiResponse<PostResultsResponseDTO>> postResults(
            @Valid @RequestBody PostResultsRequestDTO postResultsRequestDTO) {

        PostResultsResponseDTO response = resultsService.postResultsService(postResultsRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.<PostResultsResponseDTO>builder()
                .success(true)
                .message("Result posted successfully")
                .data(response)
                .build());

    }

    @PostMapping("/getResultsByEnrollmentId")
    public ResponseEntity<ApiResponse<ResultsByEnrollmentResponseDTO>> getResultsByEnrollmentId(
            @Valid @RequestBody ResultsRequestByEnrollmentIdDTO resultsRequestByEnrollmentIdDTO) {

        ResultsByEnrollmentResponseDTO response = resultsService.getResultsByEnrollmentIdService(resultsRequestByEnrollmentIdDTO);

        return ResponseEntity.ok(ApiResponse.<ResultsByEnrollmentResponseDTO>builder()
                .success(true)
                .message("Result retrieved successfully for enrollment ID: " + resultsRequestByEnrollmentIdDTO.getEnrollmentId())
                .data(response)
                .build());
    }
}
