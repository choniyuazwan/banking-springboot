package com.sti.bootcamp.banking.exception;

import com.sti.bootcamp.banking.model.dto.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<CommonResponse> catchCustomException(CustomException e) {
        LOGGER.info("catchCustomException");
        LOGGER.error(e.getMessage());
        LOGGER.warn(e.getMessage());
        LOGGER.debug(e.getMessage());
        return new ResponseEntity<>(new CommonResponse(e.getCode(), e.getDescription()), HttpStatus.OK);
    }
}
