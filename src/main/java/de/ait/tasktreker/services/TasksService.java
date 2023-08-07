package de.ait.tasktreker.services;

import de.ait.tasktreker.dto.NewTaskDto;
import de.ait.tasktreker.dto.TaskDto;
import de.ait.tasktreker.dto.TasksDto;

public interface TasksService {
  TaskDto addTask(Long idUser, NewTaskDto newTask);

  TasksDto getUserTasks(Long idUser);

}
