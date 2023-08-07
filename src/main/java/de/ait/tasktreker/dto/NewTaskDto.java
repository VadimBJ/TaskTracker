package de.ait.tasktreker.dto;

import de.ait.tasktreker.validation.constraints.BeforeCurrentDate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Schema(description = "New task")
public class NewTaskDto {

  @NotNull
  @NotBlank
  @Schema(description = "Task title", example = "Task 1")
  String title;

  @NotNull
  @NotBlank
  @Schema(description = "Task description", example = "Do your home work")
  String description;

  @BeforeCurrentDate
  @Schema(description = "Start date: YYYY-MM-DD", example = "2023-09-01")
  String startDate;

  @BeforeCurrentDate
  @Schema(description = "Finish date: YYYY-MM-DD", example = "2023-09-10")
  String finishDate;
}
