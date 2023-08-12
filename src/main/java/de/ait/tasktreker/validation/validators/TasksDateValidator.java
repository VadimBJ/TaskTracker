package de.ait.tasktreker.validation.validators;

import de.ait.tasktreker.dto.NewTaskDto;
import de.ait.tasktreker.validation.constraints.CorrectDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class TasksDateValidator implements ConstraintValidator<CorrectDate, NewTaskDto> {

  @Override
  public boolean isValid(NewTaskDto taskDto, ConstraintValidatorContext constraintValidatorContext) {
    try {
      LocalDate startDate = LocalDate.parse(taskDto.getStartDate());
      LocalDate finishDate = LocalDate.parse(taskDto.getFinishDate());

      return startDate.isBefore(finishDate);
    } catch (RuntimeException e) {
      return false;
    }
  }
}
