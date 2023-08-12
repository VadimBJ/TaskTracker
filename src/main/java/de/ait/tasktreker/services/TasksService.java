package de.ait.tasktreker.services;

import de.ait.tasktreker.dto.TasksDto;

public interface TasksService {


  TasksDto getAllTasks(Integer page, Integer items, String orderBy, Boolean desk, String filterBy, String filterValue);
}
