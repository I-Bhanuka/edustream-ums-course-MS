package com.example.edustream_courseMS.controller;

import com.example.edustream_courseMS.dto.requestDTO.ModuleRequestByModuleCode;
import com.example.edustream_courseMS.dto.requestDTO.RegisterModuleRequestDTO;
import com.example.edustream_lib_common.responseDTO.ApiResponse;
import com.example.edustream_courseMS.dto.responseDTO.ModuleRequestResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.RegisterModuleResponseDTO;
import com.example.edustream_courseMS.service.ModulesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/modules")
@RequiredArgsConstructor
public class ModulesController {

    private final ModulesService modulesService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<RegisterModuleResponseDTO>> createModule(
            @Valid @RequestBody RegisterModuleRequestDTO registerModuleRequestDTO) {

        RegisterModuleResponseDTO responseDTO = modulesService.registerModuleService(registerModuleRequestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(responseDTO, "Module created successfully"));
    }


    @PostMapping("/getModuleByModuleCode")
    public ResponseEntity<ApiResponse<ModuleRequestResponseDTO>> getModuleByModuleCode(
            @Valid @RequestBody ModuleRequestByModuleCode moduleRequestByModuleCode) {

        ModuleRequestResponseDTO responseDTO = modulesService.getModuleByModuleCodeService(moduleRequestByModuleCode);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(responseDTO, "Module retrieved successfully"));

    }

    @GetMapping("/getAllModules")
    public ResponseEntity<ApiResponse<Page<ModuleRequestResponseDTO>>> getAllModules(Pageable pageable) {

        Page<ModuleRequestResponseDTO> responseDTO = modulesService.getAllModulesService(pageable);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(responseDTO, "Modules retrieved successfully"));

    }


}
