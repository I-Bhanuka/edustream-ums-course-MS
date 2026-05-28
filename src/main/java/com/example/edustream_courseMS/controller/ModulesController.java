package com.example.edustream_courseMS.controller;

import com.example.edustream_courseMS.dto.requestDTO.ModuleRequestByModuleCode;
import com.example.edustream_courseMS.dto.requestDTO.RegisterModuleRequestDTO;
import com.example.edustream_lib_common.responseDTO.ApiResponse;
import com.example.edustream_courseMS.dto.responseDTO.ModuleRequestResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.RegisterModuleResponseDTO;
import com.example.edustream_courseMS.service.ModulesService;
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
@RequestMapping("api/modules")
@RequiredArgsConstructor
@Tag(name = "Modules Controller", description = "API endpoints for managing modules, including registration and retrieval of modules based on module code or pagination.")
@SecurityRequirement(name = "bearerAuth")
public class ModulesController {

    private final ModulesService modulesService;

    @PostMapping("/create")
    @Operation(summary = "Register a New Module", description = "Endpoint to create a new module. Accepts module details in the request body and returns the created module information.")
    public ResponseEntity<ApiResponse<RegisterModuleResponseDTO>> createModule(
            @Valid @RequestBody RegisterModuleRequestDTO registerModuleRequestDTO) {

        RegisterModuleResponseDTO responseDTO = modulesService.registerModuleService(registerModuleRequestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(responseDTO, "Module created successfully"));
    }


    @PostMapping("/getModuleByModuleCode")
    @Operation(summary = "Get Module by Module Code", description = "Endpoint to retrieve a module based on the provided module code. Accepts a request body containing the module code and returns the corresponding module information.")
    public ResponseEntity<ApiResponse<ModuleRequestResponseDTO>> getModuleByModuleCode(
            @Valid @RequestBody ModuleRequestByModuleCode moduleRequestByModuleCode) {

        ModuleRequestResponseDTO responseDTO = modulesService.getModuleByModuleCodeService(moduleRequestByModuleCode);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(responseDTO, "Module retrieved successfully"));

    }

    @GetMapping("/getAllModules")
    @Operation(summary = "Get All Modules with Pagination", description = "Endpoint to retrieve a paginated list of all modules. Accepts pagination parameters and returns a paginated response containing module information.")
    public ResponseEntity<ApiResponse<Page<ModuleRequestResponseDTO>>> getAllModules(Pageable pageable) {

        Page<ModuleRequestResponseDTO> responseDTO = modulesService.getAllModulesService(pageable);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(responseDTO, "Modules retrieved successfully"));

    }


}
