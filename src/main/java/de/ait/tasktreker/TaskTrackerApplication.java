package de.ait.tasktreker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;

@Validated
@SpringBootApplication
public class TaskTrackerApplication {

  public static void main(String[] args) {
    SpringApplication.run(TaskTrackerApplication.class, args);
  }
}
