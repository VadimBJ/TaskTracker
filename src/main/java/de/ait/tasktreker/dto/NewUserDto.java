package de.ait.tasktreker.dto;

import de.ait.tasktreker.validation.constraints.NotWeakPassword;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Schema(description = "New user data")
public class NewUserDto {

  @Email
  @NotNull
  @NotBlank
  @Schema(description = "User email", example = "example@mail.com")
  private String email;

  @NotBlank
  @Size(min = 7, max = 1000)
  @NotWeakPassword
  @Schema(description = "User password", example = "Password8@!")
  private String password;
}
