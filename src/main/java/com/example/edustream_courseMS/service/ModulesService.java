package com.example.edustream_courseMS.service;

import com.example.edustream_courseMS.dto.requestDTO.RegisterModuleRequestDTO;
import com.example.edustream_courseMS.dto.responseDTO.RegisterModuleResponseDTO;

public interface ModulesService {

    RegisterModuleResponseDTO registerModule(RegisterModuleRequestDTO registerModuleRequestDTO);
}
