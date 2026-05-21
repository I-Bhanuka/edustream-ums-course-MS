package com.example.edustream_courseMS.service.impl;

import com.example.edustream_courseMS.dto.requestDTO.RegisterSemesterRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.RequestSemesterById;
import com.example.edustream_courseMS.dto.responseDTO.RegisterSemesterResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.SemesterRequestResponseDTO;
import com.example.edustream_courseMS.entity.Semester;
import com.example.edustream_courseMS.exception.SemesterNotFoundException;
import com.example.edustream_courseMS.repository.SemesterRepository;
import com.example.edustream_courseMS.service.SemesterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SemesterServiceImpl implements SemesterService {

    private final SemesterRepository semesterRepository;

    @Override
    public RegisterSemesterResponseDTO registerSemesterService(RegisterSemesterRequestDTO registerSemesterRequestDTO) {

        log.info("================================ Registering New Semester ==============================");

        log.info("Register Request details - Semester Name: {}, Semster Number: {}, Semester Year: {}, Semester Start Date: {}, Semester End Date: {}",
                registerSemesterRequestDTO.getName(),
                registerSemesterRequestDTO.getSemesterNo(),
                registerSemesterRequestDTO.getYear(),
                registerSemesterRequestDTO.getStartDate(),
                registerSemesterRequestDTO.getEndDate());

        // Create a new Semester entity with the requested data
        Semester registerModule = Semester.builder()
                .name(registerSemesterRequestDTO.getName())
                .year(registerSemesterRequestDTO.getYear())
                .semesterNo(registerSemesterRequestDTO.getSemesterNo())
                .startDate(registerSemesterRequestDTO.getStartDate())
                .endDate(registerSemesterRequestDTO.getEndDate())
                .build();

        // Save the new semester to the database
        log.info("Saving new semester to database with semester Name: {} and semster No: {} ",
                registerSemesterRequestDTO.getName(),
                registerSemesterRequestDTO.getSemesterNo());

        semesterRepository.save(registerModule);

        return RegisterSemesterResponseDTO.builder()
                .name(registerModule.getName())
                .year(registerModule.getYear())
                .semesterNo(registerModule.getSemesterNo())
                .startDate(registerModule.getStartDate())
                .endDate(registerModule.getEndDate())
                .build();

    }

    @Override
    public SemesterRequestResponseDTO getSemesterByIdService(RequestSemesterById requestSemesterById) {

            log.info("================================ Retrieve Semester by ID ==============================");

            log.info("Retrieve Request details - Semester ID: {}",
                    requestSemesterById.getSemesterId());

            Semester semester = semesterRepository.findById(requestSemesterById.getSemesterId())
                    .orElseThrow(() -> new SemesterNotFoundException(requestSemesterById.getSemesterId().toString()));

            log.info("Semester found with ID: {}. Semester Name: {}, Semester Number: {}, Semester Year: {}, Semester Start Date: {}, Semester End Date: {}",
                    semester.getId(),
                    semester.getName(),
                    semester.getSemesterNo(),
                    semester.getYear(),
                    semester.getStartDate(),
                    semester.getEndDate());

            return SemesterRequestResponseDTO.builder()
                    .name(semester.getName())
                    .year(semester.getYear())
                    .semesterNo(semester.getSemesterNo())
                    .startDate(semester.getStartDate())
                    .endDate(semester.getEndDate())
                    .build();
    }
}
