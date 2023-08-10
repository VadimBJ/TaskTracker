package de.ait.tasktreker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Error info")
public class ErrorDto {

  @Schema(description = "Error message", example = "User with id <1> not found")
  private String message;

}
