package de.ait.tasktreker.services.impl;

import de.ait.tasktreker.dto.NewTaskDto;
import de.ait.tasktreker.dto.TaskDto;
import de.ait.tasktreker.dto.TasksDto;
import de.ait.tasktreker.exceptions.IncorrectUserIdException;
import de.ait.tasktreker.models.Task;
import de.ait.tasktreker.models.User;
import de.ait.tasktreker.repositories.TasksRepository;
import de.ait.tasktreker.repositories.UsersRepository;
import de.ait.tasktreker.services.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static de.ait.tasktreker.dto.TaskDto.from;

@RequiredArgsConstructor
@Service
public class TaskServicesImpl implements TasksService {

  private final UsersRepository usersRepository;
  private final TasksRepository tasksRepository;

  @Override
  public TaskDto addTask(Long idUser, NewTaskDto newTask) {
    User user = usersRepository.findById(idUser)
        .orElseThrow(() ->
            new IncorrectUserIdException("Id <" + idUser + "> is not correct"));

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

    return from(task);
  }

  @Override
  public TasksDto getUserTasks(Long idUser) {
    User user = usersRepository.findById(idUser)
        .orElseThrow(() ->
            new IncorrectUserIdException("Id <" + idUser + "> is not correct"));
    List<Task> tasks = tasksRepository.findAllByUserId(user);

    return TasksDto.builder()
        .tasks(TaskDto.from(tasks))
        .count(tasks.size())
        .build();
  }
}
