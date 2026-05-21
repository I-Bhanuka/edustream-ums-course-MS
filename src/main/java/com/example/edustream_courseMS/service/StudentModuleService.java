package com.example.edustream_courseMS.service;

import com.example.edustream_courseMS.dto.requestDTO.EnrollStudentToModuleRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.RequestModuleEnrollmentById;
import com.example.edustream_courseMS.dto.responseDTO.EnrollStudentToModuleResponseDTO;

public interface StudentModuleService {

    EnrollStudentToModuleResponseDTO enrollStudentInModuleService(EnrollStudentToModuleRequestDTO enrollStudentToModuleRequestDTO);

    EnrollStudentToModuleResponseDTO getEnrollmentByIdService(RequestModuleEnrollmentById requestModuleEnrollmentById);
}
