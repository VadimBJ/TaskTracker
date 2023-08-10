package de.ait.tasktreker.exceptions;

public class IncorrectUserIdException extends RuntimeException {
  public IncorrectUserIdException(Long incorrectId) {
    super(incorrectId.toString());
  }
}
