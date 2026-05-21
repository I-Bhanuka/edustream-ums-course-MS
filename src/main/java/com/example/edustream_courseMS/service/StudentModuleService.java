package com.example.edustream_courseMS.service;

import com.example.edustream_courseMS.dto.requestDTO.RegisterEnrollStudentToModuleRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.RequestModuleEnrollmentById;
import com.example.edustream_courseMS.dto.responseDTO.EnrollStudentToModuleResponseDTO;
import com.example.edustream_courseMS.entity.StudentModule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentModuleService {

    EnrollStudentToModuleResponseDTO enrollStudentInModuleService(RegisterEnrollStudentToModuleRequestDTO registerEnrollStudentToModuleRequestDTO);

    EnrollStudentToModuleResponseDTO getEnrollmentByIdService(RequestModuleEnrollmentById requestModuleEnrollmentById);

    Page<StudentModule> getAllEnrollmentsService(Pageable pageable);
}
