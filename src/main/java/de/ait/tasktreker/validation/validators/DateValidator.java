package de.ait.tasktreker.validation.validators;

import de.ait.tasktreker.validation.constraints.BeforeCurrentDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateValidator implements ConstraintValidator<BeforeCurrentDate, String> {

  @Override
  public boolean isValid(String date, ConstraintValidatorContext constraintValidatorContext) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate currentDate = LocalDate.now();
    LocalDate inputLocalDate = LocalDate.parse(date, formatter);

    return !inputLocalDate.isBefore(currentDate);
  }
}
