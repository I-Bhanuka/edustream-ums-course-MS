package com.example.edustream_courseMS.service.impl;

import com.example.edustream_courseMS.dto.requestDTO.RegisterGradeScaleRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.RequestGradeScaleByGrade;
import com.example.edustream_courseMS.dto.responseDTO.GradeScaleRequestResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.RegisterGradeScaleResponseDTO;
import com.example.edustream_courseMS.entity.Course;
import com.example.edustream_courseMS.entity.GradeScale;
import com.example.edustream_courseMS.exception.CourseNotFoundException;
import com.example.edustream_courseMS.exception.GradeScaleNotFoundException;
import com.example.edustream_courseMS.repository.GradeScaleRepository;
import com.example.edustream_courseMS.service.GradeScaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GradeScaleServiceImpl implements GradeScaleService {

    private final GradeScaleRepository gradeScaleRepository;

    @Override
    public RegisterGradeScaleResponseDTO registerGradeScaleService(RegisterGradeScaleRequestDTO registerGradeScaleRequestDTO) {

        log.info("================================ Registering New Grade Scale ==============================");

        log.info("Register Request details - Grade: {}, Min: {}, Max: {}, GradePoint: {}",
                registerGradeScaleRequestDTO.getGrade(),
                registerGradeScaleRequestDTO.getMin(),
                registerGradeScaleRequestDTO.getMax(),
                registerGradeScaleRequestDTO.getGradePoint());

        // Create a new grade scale entity with the requested data
        GradeScale registerGradeScale = GradeScale.builder()
                .grade(registerGradeScaleRequestDTO.getGrade())
                .min(registerGradeScaleRequestDTO.getMin())
                .max(registerGradeScaleRequestDTO.getMax())
                .gradePoint(registerGradeScaleRequestDTO.getGradePoint())
                .build();

        // Save the new grade scale to the database
        log.info("Saving new Grade Scale to database with the Grade: {}", registerGradeScaleRequestDTO.getGrade());
        gradeScaleRepository.save(registerGradeScale);

        return RegisterGradeScaleResponseDTO.builder()
                .grade(registerGradeScale.getGrade())
                .min(registerGradeScale.getMin())
                .max(registerGradeScale.getMax())
                .gradePoint(registerGradeScale.getGradePoint())
                .build();

    }

    public GradeScaleRequestResponseDTO getGradeScaleByGradeService(RequestGradeScaleByGrade requestGradeScaleByGrade) {

        log.info("================================ Retrieving Grade Scale by Grade ==============================");

        log.info("Request details - Grade: {}", requestGradeScaleByGrade.getGrade());

        // Retrieve the grade scale from the database based on the provided grade
        GradeScale gradeScale = gradeScaleRepository.findByGrade(requestGradeScaleByGrade.getGrade())
                .orElseThrow(() -> new GradeScaleNotFoundException(requestGradeScaleByGrade.getGrade()));

        log.info("Grade Scale retrieved successfully for Grade: {}. Min: {}, Max: {}, GradePoint: {}",
                requestGradeScaleByGrade.getGrade(),
                gradeScale.getMin(),
                gradeScale.getMax(),
                gradeScale.getGradePoint());

        return GradeScaleRequestResponseDTO.builder()
                .grade(gradeScale.getGrade())
                .min(gradeScale.getMin())
                .max(gradeScale.getMax())
                .gradePoint(gradeScale.getGradePoint())
                .build();
    }

    @Override
    public Page<GradeScale> getAllGradeScalesService(Pageable pageable) {

        // Call the database to retrieve the paginated list of courses
        log.info("Retrieving Grade Scales from database with pagination - Page Number: {}, Page Size: {}, Sort: {}",
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSort());

        Page<GradeScale> response = gradeScaleRepository.findAll(pageable);

        if (response.isEmpty()) {
            log.warn("No records were found with courses.");
            throw new GradeScaleNotFoundException("any Grade");
        }

        log.info("Retrieved Grade Scales successfully. Total number of grade scales found: {}", response.getTotalElements());

        for (GradeScale gradeScale : response) {
            log.info("Grade Scale found with Grade: {} Min: {}, Max: {}, GradePoint: {}",
                    gradeScale.getGrade(), gradeScale.getMin(), gradeScale.getMax(), gradeScale.getGradePoint());
        }

        return response;
    }

}
