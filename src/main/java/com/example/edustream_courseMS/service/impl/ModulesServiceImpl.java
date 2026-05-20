package com.example.edustream_courseMS.service.impl;

import com.example.edustream_courseMS.dto.requestDTO.ModuleRequestByModuleCode;
import com.example.edustream_courseMS.dto.requestDTO.RegisterModuleRequestDTO;
import com.example.edustream_courseMS.dto.responseDTO.ModuleRequestResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.RegisterModuleResponseDTO;
import com.example.edustream_courseMS.entity.Modules;
import com.example.edustream_courseMS.exception.ModuleNotFoundException;
import com.example.edustream_courseMS.exception.NotFoundException;
import com.example.edustream_courseMS.repository.ModulesRepository;
import com.example.edustream_courseMS.service.ModulesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ModulesServiceImpl implements ModulesService {

    private final ModulesRepository modulesRepository;

    @Override
    public RegisterModuleResponseDTO registerModuleService(RegisterModuleRequestDTO registerModuleRequestDTO) {

        log.info("================================ Registering New Module ==============================");

        log.info("Register Request details - Module Name: {}, Module Code: {}, Credit: {}",
                registerModuleRequestDTO.getModuleName(),
                registerModuleRequestDTO.getModuleCode(),
                registerModuleRequestDTO.getCredit());

        // Create a new Module entity with the requested data
        Modules registerModule = Modules.builder()
                .moduleName(registerModuleRequestDTO.getModuleName())
                .moduleCode(registerModuleRequestDTO.getModuleCode())
                .credit(registerModuleRequestDTO.getCredit())
                .build();

        // Save the new module to the database
        log.info("Saving new module to database with module code: {}", registerModuleRequestDTO.getModuleCode());
        modulesRepository.save(registerModule);

        return RegisterModuleResponseDTO.builder()
                .moduleName(registerModule.getModuleName())
                .moduleCode(registerModule.getModuleCode())
                .credit(registerModule.getCredit())
                .build();
    }

    @Override
    public ModuleRequestResponseDTO getModuleByModuleCodeService(ModuleRequestByModuleCode moduleRequestByModuleCode) {

        log.info("================================ Retrieving Module by Module Code ==============================");

        log.info("Module Code: {}", moduleRequestByModuleCode.getModuleCode());

        Modules module = modulesRepository.findByModuleCode(moduleRequestByModuleCode.getModuleCode())
                .orElseThrow(() -> new ModuleNotFoundException(moduleRequestByModuleCode.getModuleCode()));

        return ModuleRequestResponseDTO.builder()
                .moduleName(module.getModuleName())
                .moduleCode(module.getModuleCode())
                .credit(module.getCredit())
                .build();
    }

    @Override
    public Page<ModuleRequestResponseDTO> getAllModulesService(Pageable pageable){

        log.info("================================ Retrieving All Modules Paginated without UUID ==============================");

        // Call the database to retrieve the paginated list of students
        log.info("Retrieving modules without UUID from database with pagination - Page Number: {}, Page Size: {}, Sort: {}",
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSort());

        Page<ModuleRequestResponseDTO> modulesPage = modulesRepository.findAllWithoutUUID(pageable);

        if (modulesPage.isEmpty()) {
            log.warn("No records were found.");
            throw new ModuleNotFoundException("any Id");
        }

        log.info("Retrieved Modules successfully with limited details. Total number of students found: {}", modulesPage.getTotalElements());

        for (ModuleRequestResponseDTO module : modulesPage) {
            log.info("Module found with Module Code: {} Module Name: {}, Credit: {}",
                    module.getModuleName(), module.getModuleCode(), module.getCredit());
        }

        return modulesPage;
    }
}
