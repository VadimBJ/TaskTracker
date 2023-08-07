package de.ait.tasktreker.controllers.api;

import de.ait.tasktreker.dto.NewTaskDto;
import de.ait.tasktreker.dto.TaskDto;
import de.ait.tasktreker.dto.TasksDto;
import de.ait.tasktreker.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tags(value = {
    @Tag(name = "Tasks")
})
@Validated
public interface TasksApi {
  @Operation(summary = "Add task for user by user_id", description = "Everyone allowed")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "422", description = "User with the specified ID is not found",
          content = {
              @Content()
          }),
      @ApiResponse(responseCode = "201", description = "Task added",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = TaskDto.class))
          })
  })
  @PostMapping("/users/{id_user}/tasks")
  @ResponseStatus(HttpStatus.CREATED)
  ResponseEntity<TaskDto> addTask(@Parameter(required = true, description = "User id", example = "1")
                                  @PathVariable("id_user") Long idUser,
                                  @RequestBody @Valid NewTaskDto newTask);

  @Operation(summary = "Getting all user tasks", description = "Everyone allowed")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "404", description = "not found",
          content = {
              @Content()
          }),
      @ApiResponse(responseCode = "200", description = "List of user tasks",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
          })
  })
  @GetMapping("/users/{id_user}/tasks")
  ResponseEntity<TasksDto> getUserTasks(@Parameter(required = true, description = "User id", example = "1")
                                        @PathVariable("id_user") Long idUser);
}
