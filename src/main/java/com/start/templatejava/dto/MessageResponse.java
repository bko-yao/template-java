package com.start.templatejava.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO pour les réponses au format String.
 */
@Getter
@Setter
@Builder
public class MessageResponse {
    private String message;
}
