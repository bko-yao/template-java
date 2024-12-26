package com.start.templatejava.handler;

import com.start.templatejava.dto.error.ErrorDto;
import com.start.templatejava.exception.ProduitException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Classe d'écoute des des excepitons de produit.
 */
@ControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(ProduitException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDto processValidationError(ProduitException productException) {
        return ErrorDto.builder()
                .message(productException.getMessage())
                .code(productException.getErrorCode())
                .status(INTERNAL_SERVER_ERROR.value())
                .build();
    }
}
