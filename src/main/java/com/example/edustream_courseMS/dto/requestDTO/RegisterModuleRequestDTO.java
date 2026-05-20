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
public class RegisterModuleRequestDTO {

    @NotBlank(message = "module code is required")
    @NotNull(message = "module code cannot be null")
    private String moduleCode;

    @NotBlank(message = "module name is required")
    @NotNull(message = "module name cannot be null")
    private String moduleName;

    @NotNull(message = "credit is required")
    private int credit;
}
