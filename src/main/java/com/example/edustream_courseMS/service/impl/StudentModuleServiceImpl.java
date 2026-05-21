package com.example.edustream_courseMS.service.impl;

import com.example.edustream_courseMS.dto.requestDTO.RegisterEnrollStudentToModuleRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.RequestModuleEnrollmentById;
import com.example.edustream_courseMS.dto.responseDTO.EnrollStudentToModuleResponseDTO;
import com.example.edustream_courseMS.entity.StudentModule;
import com.example.edustream_courseMS.enums.StudentModuleStatus;
import com.example.edustream_courseMS.exception.EnrollmentModuleNotFoundException;
import com.example.edustream_courseMS.repository.StudentModuleRepository;
import com.example.edustream_courseMS.service.StudentModuleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentModuleServiceImpl implements StudentModuleService {

    private final StudentModuleRepository studentModuleRepository;

    @Override
    public EnrollStudentToModuleResponseDTO enrollStudentInModuleService(
            RegisterEnrollStudentToModuleRequestDTO registerEnrollStudentToModuleRequestDTO) {

        log.info("================================ Retrieving Module by Module Code ===============================");

        log.info("Enrolling Student with ID: {} to Module with ID: {} for Semester with ID: {}",
                registerEnrollStudentToModuleRequestDTO.getStudentId(),
                registerEnrollStudentToModuleRequestDTO.getModuleId(),
                registerEnrollStudentToModuleRequestDTO.getSemesterId());

        // Make the enrollment entity
        StudentModule request = StudentModule.builder()
                .studentId(registerEnrollStudentToModuleRequestDTO.getStudentId())
                .moduleId(registerEnrollStudentToModuleRequestDTO.getModuleId())
                .semesterId(registerEnrollStudentToModuleRequestDTO.getSemesterId())
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

    @Override
    public EnrollStudentToModuleResponseDTO getEnrollmentByIdService(RequestModuleEnrollmentById requestModuleEnrollmentById) {
        log.info("================================ Retrieving Student Module Enrollment by ID ===============================");
        log.info("Retrieving Student Module Enrollment with ID: {}", requestModuleEnrollmentById.getEnrollmentId());

        StudentModule studentModule = studentModuleRepository.findById(requestModuleEnrollmentById.getEnrollmentId())
                .orElseThrow(() -> new EnrollmentModuleNotFoundException("Enrollment not found with ID: " + requestModuleEnrollmentById.getEnrollmentId()));

        return EnrollStudentToModuleResponseDTO.builder()
                .studentId(studentModule.getStudentId())
                .moduleId(studentModule.getModuleId())
                .semesterId(studentModule.getSemesterId())
                .status(studentModule.getStudentModuleStatus())
                .build();
    }


    @Override
    public Page<StudentModule> getAllEnrollmentsService(Pageable pageable) {
        log.info("================================= Retrieving All Student Module Enrollments ===============================");

        log.info("Retrieving all student module enrollments with pagination - Page Number: {}, Page Size: {}",
                pageable.getPageNumber(), pageable.getPageSize());

        // Call the database to retrieve the paginated list of enrollments
        Page<StudentModule> studentModulePage = studentModuleRepository.findAll(pageable);

        // Check if the page is empty and log a warning if no records were found
        if (studentModulePage.isEmpty()) {
            log.warn("No student module enrollments were found.");
            throw new EnrollmentModuleNotFoundException("Any Id");
        }

        log.info("Retrieved student module enrollments successfully. Total number of enrollments found: {}", studentModulePage.getTotalElements());

        for (StudentModule enrollments : studentModulePage) {
            log.info("Student module enrollments found with Enrollment ID: {} Student ID: {}, Module ID: {}, Semester ID: {}, Status: {}",
                    enrollments.getId(), enrollments.getStudentId(), enrollments.getModuleId(), enrollments.getSemesterId(), enrollments.getStudentModuleStatus());
        }

        return studentModulePage;
    }

}
