package de.ait.tasktreker.services.impl;

import de.ait.tasktreker.dto.TasksDto;
import de.ait.tasktreker.models.Task;
import de.ait.tasktreker.repositories.TasksRepository;
import de.ait.tasktreker.services.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static de.ait.tasktreker.dto.TaskDto.from;

@RequiredArgsConstructor
@Service
public class TaskServicesImpl implements TasksService {

  private final TasksRepository tasksRepository;


  @Override
  public TasksDto getAllTasks(Integer page, Integer items, String orderBy, Boolean desk, String filterBy, String filterValue) {

    PageRequest pageRequest;
    Page<Task> pageOfTasks;

    if (orderBy != null && !orderBy.equals("")) {
      Sort.Direction direction = Sort.Direction.ASC;

      if (desk != null && desk) {
        direction = Sort.Direction.DESC;
      }

      Sort sort = Sort.by(direction, orderBy);
      pageRequest = PageRequest.of(page, items, sort);
    } else {
      pageRequest = PageRequest.of(page, items, Sort.by(Sort.Direction.ASC, "id"));
    }

    switch (filterBy) {
      case null, "" -> pageOfTasks = tasksRepository.findAll(pageRequest);
      case "startDate" ->
          pageOfTasks = tasksRepository.findAllByStartDate(LocalDate.parse(filterValue), pageRequest);
      case "finishDate" ->
          pageOfTasks = tasksRepository.findAllByFinishDate(LocalDate.parse(filterValue), pageRequest);
      default -> pageOfTasks = tasksRepository.findAll(pageRequest);
    }


    return TasksDto.builder()
        .tasks(from(pageOfTasks.getContent()))
        .count(pageOfTasks.getTotalElements())
        .pages(pageOfTasks.getTotalPages())
        .build();
  }
}
