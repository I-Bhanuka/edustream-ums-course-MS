package com.example.edustream_courseMS.service;


import com.example.edustream_courseMS.dto.requestDTO.PostResultsRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.ResultsRequestByEnrollmentIdDTO;
import com.example.edustream_courseMS.dto.responseDTO.PostResultsResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.ResultsByEnrollmentResponseDTO;

public interface ResultsService {

    PostResultsResponseDTO postResults(PostResultsRequestDTO postResultsRequestDTO);

    ResultsByEnrollmentResponseDTO getResultsByEnrollmentIdService(ResultsRequestByEnrollmentIdDTO resultsRequestByEnrollmentIdDTO);

}
