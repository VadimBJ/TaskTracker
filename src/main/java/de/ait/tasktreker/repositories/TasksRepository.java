package de.ait.tasktreker.repositories;

import de.ait.tasktreker.models.Task;
import de.ait.tasktreker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TasksRepository extends JpaRepository<Task, Long> {

  List<Task> findAllByUserId(User user);
}
