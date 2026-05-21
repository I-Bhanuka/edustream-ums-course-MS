package com.example.edustream_courseMS.service;


import com.example.edustream_courseMS.dto.requestDTO.PostResultsRequestDTO;
import com.example.edustream_courseMS.dto.responseDTO.PostResultsResponseDTO;

public interface ResultsService {

    PostResultsResponseDTO postResults(PostResultsRequestDTO postResultsRequestDTO);
}
