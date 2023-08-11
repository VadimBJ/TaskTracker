package de.ait.tasktreker.controllers;

import de.ait.tasktreker.controllers.api.TasksApi;
import de.ait.tasktreker.dto.NewTaskDto;
import de.ait.tasktreker.dto.TaskDto;
import de.ait.tasktreker.dto.TasksDto;
import de.ait.tasktreker.services.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TasksController implements TasksApi {

  private final TasksService tasksService;

  @Override
  public ResponseEntity<TaskDto> addTask(Long idUser, NewTaskDto newTask) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(tasksService.addTask(idUser, newTask));
  }

  @Override
  public ResponseEntity<TasksDto> getUserTasks(Long idUser) {
    return ResponseEntity
        .ok(tasksService.getUserTasks(idUser));
  }

  @Override
  public ResponseEntity<TasksDto> getAllTasks(Integer page, Integer items, String orderBy, Boolean desk, String filterBy, String filterValue) {
    return ResponseEntity
        .ok(tasksService.getAllTasks(page, items, orderBy, desk, filterBy, filterValue));
  }
}
