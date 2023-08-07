package de.ait.tasktreker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "User tasks")
public class TasksDto {

  @Schema(description = "Task list")
  private List<TaskDto> tasks;

  @Schema(description = "Number of user tasks", example = "1")
  private Integer count;
}
