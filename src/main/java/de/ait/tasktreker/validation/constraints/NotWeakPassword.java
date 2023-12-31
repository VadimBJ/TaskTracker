package de.ait.tasktreker.validation.constraints;


import de.ait.tasktreker.validation.validators.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface NotWeakPassword {

  String message() default "must be strong";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
