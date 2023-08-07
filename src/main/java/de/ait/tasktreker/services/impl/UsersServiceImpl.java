package de.ait.tasktreker.services.impl;


import de.ait.tasktreker.dto.NewUserDto;
import de.ait.tasktreker.dto.UserDto;
import de.ait.tasktreker.dto.UsersListDto;
import de.ait.tasktreker.models.User;
import de.ait.tasktreker.repositories.UsersRepository;
import de.ait.tasktreker.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.ait.tasktreker.dto.UserDto.from;


@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

  private final UsersRepository usersRepository;

  @Override
  public UserDto addUser(NewUserDto newUser) {
    User user = User.builder()
        .email(newUser.getEmail())
        .password(newUser.getPassword())
        .role(User.Role.USER)
        .state(User.State.NOT_CONFIRMED).build();

    usersRepository.save(user);

    return from(user);
  }

  @Override
  public UsersListDto getAllUsers() {
    List<User> users = usersRepository.findAll();
    return UsersListDto.builder()
        .users(from(users))
        .count(users.size())
        .build();
  }
}
