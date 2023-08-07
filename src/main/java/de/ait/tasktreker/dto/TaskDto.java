package de.ait.tasktreker.dto;

import de.ait.tasktreker.models.Task;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Task for user")
public class TaskDto {

  @Schema(description = "Task id", example = "1")
  private Long id;

  @Schema(description = "Task title", example = "Task 1")
  String title;

  @Schema(description = "Task description", example = "Do your home work")
  String description;

  @Schema(description = "Start date: YYYY-MM-DD", example = "2023-09-01")
  LocalDate startDate;

  @Schema(description = "Finish date: YYYY-MM-DD", example = "2023-09-01")
  LocalDate finishDate;

  @Schema(description = "Executor id", example = "1")
  UserInTaskDto executor;

  public static TaskDto from(Task task) {
    TaskDto result = TaskDto.builder()
        .id(task.getId())
        .title(task.getTitle())
        .description(task.getDescription())
        .startDate(task.getStartDate())
        .finishDate(task.getFinishDate())
        .build();

    if (task.getUserId() != null) {
      result.setExecutor(UserInTaskDto.from(task.getUserId()));
    }

    return result;
  }

  public static List<TaskDto> from(List<Task> tasks) {
    return tasks.stream()
        .map(TaskDto::from)
        .collect(Collectors.toList());
  }
}
