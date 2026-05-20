package com.example.edustream_courseMS.dto.responseDTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RegisterModuleResponseDTO {

    private String moduleCode;

    private String moduleName;

    private int credit;
}
