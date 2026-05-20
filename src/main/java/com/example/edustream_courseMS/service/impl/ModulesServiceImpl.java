package com.example.edustream_courseMS.service.impl;

import com.example.edustream_courseMS.dto.requestDTO.RegisterModuleRequestDTO;
import com.example.edustream_courseMS.dto.responseDTO.RegisterModuleResponseDTO;
import com.example.edustream_courseMS.entity.Modules;
import com.example.edustream_courseMS.repository.ModulesRepository;
import com.example.edustream_courseMS.service.ModulesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ModulesServiceImpl implements ModulesService {

    private final ModulesRepository modulesRepository;

    @Override
    public RegisterModuleResponseDTO registerModule(RegisterModuleRequestDTO registerModuleRequestDTO) {

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
}
