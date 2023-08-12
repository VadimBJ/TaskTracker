package de.ait.tasktreker.validation.constraints;

import de.ait.tasktreker.validation.validators.TasksDateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TasksDateValidator.class)
public @interface CorrectDate {

  String message() default "startDate must be earlier than finishDate";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
