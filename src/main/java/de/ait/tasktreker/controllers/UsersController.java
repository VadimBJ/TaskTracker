package de.ait.tasktreker.controllers;

import de.ait.tasktreker.controllers.api.UsersApi;
import de.ait.tasktreker.dto.NewUserDto;
import de.ait.tasktreker.dto.UserDto;
import de.ait.tasktreker.dto.UsersListDto;
import de.ait.tasktreker.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UsersController implements UsersApi {

  private final UsersService usersService;

  @Override
  public ResponseEntity<UserDto> addUser(NewUserDto newUser) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(usersService.addUser(newUser));
  }

  @Override
  public ResponseEntity<UsersListDto> getAllUsers() {
    return ResponseEntity
        .ok(usersService.getAllUsers());
  }
}
