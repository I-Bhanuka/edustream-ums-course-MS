package com.example.edustream_courseMS.service.impl;

import com.example.edustream_courseMS.dto.requestDTO.EnrollStudentToModuleRequestDTO;
import com.example.edustream_courseMS.dto.responseDTO.EnrollStudentToModuleResponseDTO;
import com.example.edustream_courseMS.entity.StudentModule;
import com.example.edustream_courseMS.enums.StudentModuleStatus;
import com.example.edustream_courseMS.repository.StudentModuleRepository;
import com.example.edustream_courseMS.service.StudentModuleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentModuleServiceImpl implements StudentModuleService {

    private final StudentModuleRepository studentModuleRepository;

    @Override
    public EnrollStudentToModuleResponseDTO enrollStudentInModuleService(
            EnrollStudentToModuleRequestDTO enrollStudentToModuleRequestDTO) {

        log.info("================================ Retrieving Module by Module Code ===============================");

        log.info("Enrolling Student with ID: {} to Module with ID: {} for Semester with ID: {}",
                enrollStudentToModuleRequestDTO.getStudentId(),
                enrollStudentToModuleRequestDTO.getModuleId(),
                enrollStudentToModuleRequestDTO.getSemesterId());

        // Make the enrollment entity
        StudentModule request = StudentModule.builder()
                .studentId(enrollStudentToModuleRequestDTO.getStudentId())
                .moduleId(enrollStudentToModuleRequestDTO.getModuleId())
                .semesterId(enrollStudentToModuleRequestDTO.getSemesterId())
                .studentModuleStatus(StudentModuleStatus.ACTIVE)
                .build();

        // Save it in the DB
        studentModuleRepository.save(request);

        return EnrollStudentToModuleResponseDTO.builder()
                .studentId(request.getStudentId())
                .moduleId(request.getModuleId())
                .semesterId(request.getSemesterId())
                .status(StudentModuleStatus.ACTIVE)
                .build();

    }

}
