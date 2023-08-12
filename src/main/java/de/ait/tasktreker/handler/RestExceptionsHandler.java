package de.ait.tasktreker.handler;

import de.ait.tasktreker.dto.ErrorDto;
import de.ait.tasktreker.exceptions.RestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionsHandler {

  @ExceptionHandler(RestException.class)
  public ResponseEntity<ErrorDto> handleException(RestException e) {
    return ResponseEntity
        .status(e.getHttpStatus())
        .body(ErrorDto.builder()
            .message(e.getMessage())
            .build());
  }
}
