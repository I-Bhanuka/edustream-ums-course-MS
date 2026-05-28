package com.example.edustream_courseMS.controller;

import com.example.edustream_courseMS.dto.requestDTO.PostResultsRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.ResultsRequestByEnrollmentIdDTO;
import com.example.edustream_lib_common.responseDTO.ApiResponse;
import com.example.edustream_courseMS.dto.responseDTO.PostResultsResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.ResultsByEnrollmentResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.ResultsResponseDTO;
import com.example.edustream_courseMS.service.ResultsService;
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
@RequestMapping("/api/results")
@RequiredArgsConstructor
@Tag(name = "Results Controller", description = "API endpoints for managing results, including posting results, retrieving results by enrollment ID, and retrieving all results with pagination.")
@SecurityRequirement(name = "bearerAuth")
public class ResultsController {

    private final ResultsService resultsService;

    @PostMapping("/postResults")
    @Operation(summary = "Post Results", description = "Endpoint to post results for a student. Accepts result details in the request body and returns the posted result information.")
    public ResponseEntity<ApiResponse<PostResultsResponseDTO>> postResults(
            @Valid @RequestBody PostResultsRequestDTO postResultsRequestDTO) {

        PostResultsResponseDTO response = resultsService.postResultsService(postResultsRequestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(response, "Result posted successfully"));

    }

    @PostMapping("/getResultsByEnrollmentId")
    @Operation(summary = "Get Results by Enrollment ID", description = "Endpoint to retrieve results based on the provided enrollment ID. Accepts a request body containing the enrollment ID and returns the corresponding results information.")
    public ResponseEntity<ApiResponse<ResultsByEnrollmentResponseDTO>> getResultsByEnrollmentId(
            @Valid @RequestBody ResultsRequestByEnrollmentIdDTO resultsRequestByEnrollmentIdDTO) {

        ResultsByEnrollmentResponseDTO response = resultsService.getResultsByEnrollmentIdService(resultsRequestByEnrollmentIdDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(response, "Result retrieved successfully for enrollment ID: " + resultsRequestByEnrollmentIdDTO.getEnrollmentId()));

    }

    @GetMapping("/getAll")
    @Operation(summary = "Get All Results with Pagination", description = "Endpoint to retrieve a paginated list of all results. Accepts pagination parameters and returns a paginated response containing results information.")
    public ResponseEntity<ApiResponse<Page<ResultsResponseDTO>>> getAllResults(Pageable pageable) {

        Page<ResultsResponseDTO> response = resultsService.getAllResultsService(pageable);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(response, "All results retrieved successfully"));

    }
}
