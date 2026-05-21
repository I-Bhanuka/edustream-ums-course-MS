package com.example.edustream_courseMS.service;

import com.example.edustream_courseMS.dto.requestDTO.RegisterSemesterRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.RequestSemesterById;
import com.example.edustream_courseMS.dto.responseDTO.RegisterSemesterResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.SemesterRequestResponseDTO;
import com.example.edustream_courseMS.entity.Semester;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SemesterService {

    RegisterSemesterResponseDTO registerSemesterService(RegisterSemesterRequestDTO registerSemesterRequestDTO);

    SemesterRequestResponseDTO getSemesterByIdService(RequestSemesterById requestSemesterById);

    Page<Semester> getAllSemestersService(Pageable pageable);
}
