package com.ricardococati.swapi.config.advice;

import com.ricardococati.swapi.gateways.http.json.ErrorResponseJson;
import com.ricardococati.swapi.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ApplicationAdvice {

  @ExceptionHandler({
      NotFoundException.class
  })
  public ResponseEntity<ErrorResponseJson> handleValidationException(NotFoundException ex) {
    return createErrorResponse(ex, HttpStatus.BAD_REQUEST);
  }

  private ResponseEntity<ErrorResponseJson> createErrorResponse(Throwable ex,
      HttpStatus httpStatus) {
    log.error(ex.getMessage(), ex);
    return new ResponseEntity<>(new ErrorResponseJson(ex.getMessage()), httpStatus);
  }
}
