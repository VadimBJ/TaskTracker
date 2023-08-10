package de.ait.tasktreker.handler;

import de.ait.tasktreker.dto.ErrorDto;
import de.ait.tasktreker.exceptions.IncorrectUserIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionsHandler {

  @ExceptionHandler(IncorrectUserIdException.class)
  public ResponseEntity<ErrorDto> handleException(IncorrectUserIdException e) {
    return ResponseEntity
        .status(HttpStatus.UNPROCESSABLE_ENTITY)
        .body(ErrorDto.builder()
            .message("User with id <" + e.getMessage() + "> not found")
            .build());
  }
}
