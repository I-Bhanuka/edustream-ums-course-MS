package com.example.edustream_courseMS.service;


import com.example.edustream_courseMS.dto.requestDTO.PostResultsRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.ResultsRequestByEnrollmentIdDTO;
import com.example.edustream_courseMS.dto.responseDTO.PostResultsResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.ResultsByEnrollmentResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.ResultsResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ResultsService {

    PostResultsResponseDTO postResultsService(PostResultsRequestDTO postResultsRequestDTO);

    ResultsByEnrollmentResponseDTO getResultsByEnrollmentIdService(ResultsRequestByEnrollmentIdDTO resultsRequestByEnrollmentIdDTO);

    Page<ResultsResponseDTO> getAllResultsService(Pageable pageable);

}
