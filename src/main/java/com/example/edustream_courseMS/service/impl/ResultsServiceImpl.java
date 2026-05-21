package com.example.edustream_courseMS.service.impl;

import com.example.edustream_courseMS.dto.requestDTO.PostResultsRequestDTO;
import com.example.edustream_courseMS.dto.responseDTO.GradeAndGradePointResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.PostResultsResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.RegisterCourseResponseDTO;
import com.example.edustream_courseMS.entity.Course;
import com.example.edustream_courseMS.entity.Results;
import com.example.edustream_courseMS.enums.CourseStatus;
import com.example.edustream_courseMS.repository.GradeScaleRepository;
import com.example.edustream_courseMS.repository.ResultsRepository;
import com.example.edustream_courseMS.service.ResultsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ResultsServiceImpl implements ResultsService {

    private final ResultsRepository resultsRepository;
    private final GradeScaleRepository gradeScaleRepository;

    @Override
    public PostResultsResponseDTO postResults(PostResultsRequestDTO postResultsRequestDTO) {

        log.info("================================ Post a Result into the system ==============================");

        log.info("Register Request details - Enrollment ID: {}, Mark: {}",
                postResultsRequestDTO.getEnrollmentId(),
                postResultsRequestDTO.getMark());

        // Calculating the grade based on the mark
        GradeAndGradePointResponseDTO gradeAndGradePoint = gradeScaleRepository.findGradeAndGradePointByMark(postResultsRequestDTO.getMark());

        log.info("Grade and Grade Point calculated for mark {}: Grade - {}, Grade Point - {}",
                postResultsRequestDTO.getMark(),
                gradeAndGradePoint.getGrade(),
                gradeAndGradePoint.getGradePoint());

        // Create a new result entity with the requested data and calculated grade and grade point
        Results results = Results.builder()
                .enrollmentId(postResultsRequestDTO.getEnrollmentId())
                .mark(postResultsRequestDTO.getMark())
                .grade(gradeAndGradePoint.getGrade())
                .gradePoint(gradeAndGradePoint.getGradePoint())
                .build();

        // Save the new Result into the database
        log.info("Saving new Result into the database...");
        resultsRepository.save(results);

        return PostResultsResponseDTO.builder()
                .enrollmentId(results.getEnrollmentId())
                .mark(results.getMark())
                .grade(results.getGrade())
                .gradePoint(results.getGradePoint())
                .build();
    }
}
