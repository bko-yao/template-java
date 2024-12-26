package com.start.templatejava.handler;

import com.start.templatejava.dto.error.ErrorDto;
import com.start.templatejava.exception.DateException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Classe d'écoute des des excepitons de Date.
 */
@ControllerAdvice
public class DateExceptionHandler {

    @ExceptionHandler(DateException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDto processValidationError(DateException ex) {
        return ErrorDto.builder()
                .message(ex.getMessage())
                .code(ex.getErrorCode())
                .status(INTERNAL_SERVER_ERROR.value())
                .build();
    }
}