package com.example.edustream_courseMS.service;

import com.example.edustream_courseMS.dto.requestDTO.RegisterCourseRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.RegisterGradeScaleRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.RequestGradeScaleByGrade;
import com.example.edustream_courseMS.dto.responseDTO.GradeScaleRequestResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.RegisterGradeScaleResponseDTO;
import com.example.edustream_courseMS.entity.GradeScale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GradeScaleService {

    RegisterGradeScaleResponseDTO registerGradeScaleService(RegisterGradeScaleRequestDTO registerGradeScaleRequestDTO);

    GradeScaleRequestResponseDTO getGradeScaleByGradeService(RequestGradeScaleByGrade requestGradeScaleByGrade);

    Page<GradeScale> getAllGradeScalesService(Pageable pageable);


}
