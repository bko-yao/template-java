package com.start.templatejava.dto.error;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO pour les erreurs.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {
    private Integer httpCode;
    private int code;
    private String message;
    private int status;
    private List<String> errors = new ArrayList<>();
}
