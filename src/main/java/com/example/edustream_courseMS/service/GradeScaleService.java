package com.example.edustream_courseMS.service;

import com.example.edustream_courseMS.dto.requestDTO.RegisterCourseRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.RegisterGradeScaleRequestDTO;
import com.example.edustream_courseMS.dto.requestDTO.RequestGradeScaleByGrade;
import com.example.edustream_courseMS.dto.responseDTO.GradeScaleRequestResponseDTO;
import com.example.edustream_courseMS.dto.responseDTO.RegisterGradeScaleResponseDTO;

public interface GradeScaleService {

    RegisterGradeScaleResponseDTO registerGradeScaleService(RegisterGradeScaleRequestDTO registerGradeScaleRequestDTO);

    GradeScaleRequestResponseDTO getGradeScaleByGradeService(RequestGradeScaleByGrade requestGradeScaleByGrade);


}
