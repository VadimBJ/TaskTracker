package de.ait.tasktreker.controllers.api;

import de.ait.tasktreker.dto.TasksDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tags(value = {
    @Tag(name = "Tasks")
})
@Validated
@RequestMapping("/api/tasks")
public interface TasksApi {

  @Operation(summary = "Getting all tasks", description = "Everyone allowed")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Tasks list",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = TasksDto.class))
          })})
  @GetMapping
  ResponseEntity<TasksDto> getAllTasks(@Parameter(required = true, description = "Page number", example = "0")
                                       @RequestParam(value = "page") Integer page,
                                       @Parameter(required = true, description = "Number of items per page", example = "3")
                                       @RequestParam(value = "items") Integer items,
                                       @Parameter(description = "Sorting field: id, title, description, startDate, finishDate (default field: id)", example = "title")
                                       @RequestParam(value = "orderBy", required = false) String orderBy,
                                       @Parameter(description = "Sorting direction (true = DESK, false = ASK)", example = "true")
                                       @RequestParam(value = "desk", required = false) Boolean desk,
                                       @Parameter(description = "Filter field: startDate, finishDate", example = "startDate")
                                       @RequestParam(value = "filterBy", required = false) String filterBy,
                                       @Parameter(description = "Filter field value", example = "2023-09-01")
                                       @RequestParam(value = "filterValue", required = false) String filterValue);
}
