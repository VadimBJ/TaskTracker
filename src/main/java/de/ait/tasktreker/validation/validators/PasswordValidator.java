package de.ait.tasktreker.validation.validators;


import de.ait.tasktreker.validation.constraints.NotWeakPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<NotWeakPassword, String> {

  private static final Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

  @Override
  public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
    Matcher matcher = pattern.matcher(password);
    return matcher.matches();
  }
}
