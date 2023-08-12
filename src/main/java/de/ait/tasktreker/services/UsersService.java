package de.ait.tasktreker.services;

import de.ait.tasktreker.dto.*;

public interface UsersService {

  UserDto addUser(NewUserDto newUser);

  UsersListDto getAllUsers();

  TaskDto addTask(Long idUser, NewTaskDto newTask);

  TasksDto getUserTasks(Long idUser);
}
