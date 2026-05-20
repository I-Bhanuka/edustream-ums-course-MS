package com.example.edustream_courseMS.service;

import com.example.edustream_courseMS.dto.requestDTO.ModuleRequestByModuleCode;
import com.example.edustream_courseMS.dto.requestDTO.RegisterModuleRequestDTO;
import com.example.edustream_courseMS.dto.responseDTO.ModuleRequestResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.RegisterModuleResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ModulesService {

    RegisterModuleResponseDTO registerModuleService(RegisterModuleRequestDTO registerModuleRequestDTO);

    ModuleRequestResponseDTO getModuleByModuleCodeService(ModuleRequestByModuleCode moduleRequestByModuleCode);

    Page<ModuleRequestResponseDTO> getAllModulesService(Pageable pageable);
}
