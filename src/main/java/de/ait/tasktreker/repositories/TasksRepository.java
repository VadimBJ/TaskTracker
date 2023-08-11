package de.ait.tasktreker.repositories;

import de.ait.tasktreker.models.Task;
import de.ait.tasktreker.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TasksRepository extends JpaRepository<Task, Long> {

  List<Task> findAllByUserId(User user);

  Page<Task> findAllByStartDate(LocalDate startDate, Pageable pageable);
  Page<Task> findAllByFinishDate(LocalDate finishDate, Pageable pageable);
}
