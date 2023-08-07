package de.ait.tasktreker.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  String title;
  String description;
  LocalDate startDate;
  LocalDate finishDate;

  @ManyToOne
  @JoinColumn(name = "user_id")
  User userId;
}
