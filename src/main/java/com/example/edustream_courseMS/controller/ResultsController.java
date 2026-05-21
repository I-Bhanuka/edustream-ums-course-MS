package com.example.edustream_courseMS.controller;

import com.example.edustream_courseMS.dto.requestDTO.PostResultsRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.ResultsRequestByEnrollmentIdDTO;
import com.example.edustream_courseMS.dto.responseDTO.ApiResponse;
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

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse<Page<ResultsResponseDTO>>> getAllResults(Pageable pageable) {

        Page<ResultsResponseDTO> response = resultsService.getAllResultsService(pageable);

        return ResponseEntity.ok(ApiResponse.<Page<ResultsResponseDTO>>builder()
                .success(true)
                .message("All results retrieved successfully")
                .data(response)
                .build());
    }
}
