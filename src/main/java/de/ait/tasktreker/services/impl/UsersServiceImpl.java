package de.ait.tasktreker.services.impl;

import de.ait.tasktreker.dto.*;
import de.ait.tasktreker.exceptions.NotFoundUserIdException;
import de.ait.tasktreker.models.Task;
import de.ait.tasktreker.models.User;
import de.ait.tasktreker.repositories.TasksRepository;
import de.ait.tasktreker.repositories.UsersRepository;
import de.ait.tasktreker.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static de.ait.tasktreker.dto.UserDto.from;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

  private final UsersRepository usersRepository;
  private final TasksRepository tasksRepository;

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

  @Override
  public TaskDto addTask(Long idUser, NewTaskDto newTask) {
    User user = usersRepository.findById(idUser)
        .orElseThrow(() ->
            new NotFoundUserIdException(idUser));

    Task task = Task.builder()
        .title(newTask.getTitle())
        .description(newTask.getDescription())
        .startDate(LocalDate.parse(newTask.getStartDate()))
        .finishDate(LocalDate.parse(newTask.getFinishDate()))
        .userId(user)
        .build();

    tasksRepository.save(task);
    user.getTasks().add(task);
    usersRepository.save(user);

    return TaskDto.from(task);
  }

  @Override
  public TasksDto getUserTasks(Long idUser) {
    User user = usersRepository.findById(idUser)
        .orElseThrow(() ->
            new NotFoundUserIdException(idUser));
    List<Task> tasks = tasksRepository.findAllByUserId(user);

    return TasksDto.builder()
        .tasks(TaskDto.from(tasks))
        .count((long) tasks.size())
        .build();
  }
}
