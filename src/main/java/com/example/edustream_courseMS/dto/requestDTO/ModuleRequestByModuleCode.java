package com.example.edustream_courseMS.dto.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ModuleRequestByModuleCode {

    @NotBlank(message = "module code is required")
    @NotNull(message = "module code is required")
    private String moduleCode;
}
