package de.ait.tasktreker.validation.constraints;

import de.ait.tasktreker.validation.validators.DateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidator.class)
public @interface BeforeCurrentDate {

  String message() default "Specified date cannot be earlier than the current date";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
