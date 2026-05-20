package com.example.edustream_courseMS.controller;

import com.example.edustream_courseMS.dto.requestDTO.ModuleRequestByModuleCode;
import com.example.edustream_courseMS.dto.requestDTO.RegisterModuleRequestDTO;
import com.example.edustream_courseMS.dto.responseDTO.ApiResponse;
import com.example.edustream_courseMS.dto.responseDTO.ModuleRequestResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.RegisterModuleResponseDTO;
import com.example.edustream_courseMS.service.ModulesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.<RegisterModuleResponseDTO>builder()
                        .success(true)
                        .message("Module created successfully")
                        .data(responseDTO)
                        .build());
    }


    @PostMapping("/getModuleByModuleCode")
    public ResponseEntity<ApiResponse<ModuleRequestResponseDTO>> getModuleByModuleCode(
            @Valid @RequestBody ModuleRequestByModuleCode moduleRequestByModuleCode) {

            ModuleRequestResponseDTO responseDTO = modulesService.getModuleByModuleCodeService(moduleRequestByModuleCode);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(ApiResponse.<ModuleRequestResponseDTO>builder()
                            .success(true)
                            .message("Module retrieved successfully")
                            .data(responseDTO)
                            .build());
    }


}
