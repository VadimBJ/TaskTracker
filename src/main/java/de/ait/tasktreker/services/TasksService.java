package de.ait.tasktreker.services;

import de.ait.tasktreker.dto.NewTaskDto;
import de.ait.tasktreker.dto.TaskDto;
import de.ait.tasktreker.dto.TasksDto;
import org.springframework.http.ResponseEntity;

public interface TasksService {
  TaskDto addTask(Long idUser, NewTaskDto newTask);

  TasksDto getUserTasks(Long idUser);

  TasksDto getAllTasks(Integer page, Integer items, String orderBy, Boolean desk, String filterBy, String filterValue);
}
