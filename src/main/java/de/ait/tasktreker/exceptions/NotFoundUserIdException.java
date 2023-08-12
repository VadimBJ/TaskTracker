package de.ait.tasktreker.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundUserIdException extends RestException {
  public NotFoundUserIdException(Long incorrectId) {
    super(HttpStatus.UNPROCESSABLE_ENTITY, "User with id <" + incorrectId + "> not found");
  }
}
