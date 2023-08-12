package de.ait.tasktreker.validation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Validation error")
public class ValidationErrorDto {

  @Schema(description = "Field with error", example = "email")
  private String field;

  @Schema(description = "Error message", example = "must be a well-formed email address")
  private String message;

  @Schema(description = "Received data", example = "sidikov.marsel.com")
  private String rejectedValue;
}
