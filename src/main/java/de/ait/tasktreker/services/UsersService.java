package de.ait.tasktreker.services;

import de.ait.tasktreker.dto.NewUserDto;
import de.ait.tasktreker.dto.UserDto;
import de.ait.tasktreker.dto.UsersListDto;

public interface UsersService {

  UserDto addUser(NewUserDto newUser);

  UsersListDto getAllUsers();
}
