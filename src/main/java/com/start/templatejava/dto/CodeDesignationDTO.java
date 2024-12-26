package com.start.templatejava.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO pour toute les classes qui ont que
 * les champs code et designation
 */
@Getter
@Setter
@NoArgsConstructor
public class CodeDesignationDTO {
    private String code;
    @NotBlank
    private String designation;

    public CodeDesignationDTO(String code, String designation) {
        this.code = code;
        this.designation = designation;
    }
}
