package com.example.edustream_courseMS.dto.responseDTO;

import com.example.edustream_courseMS.enums.StudentModuleStatus;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class EnrollStudentToModuleResponseDTO {

    private UUID studentId;

    private UUID moduleId;

    private UUID semesterId;

    private StudentModuleStatus status;
}
