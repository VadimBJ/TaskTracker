package de.ait.tasktreker.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String email;
  private String password;

  @Enumerated(value = EnumType.STRING)
  private Role role;

  @Enumerated(value = EnumType.STRING)
  private State state;

  @OneToMany(mappedBy = "userId")
  private List<Task> tasks;

  public enum Role {
    ADMIN,
    USER,
  }

  public enum State {
    NOT_CONFIRMED,
    CONFIRMED,
    BANNED,
    DELETED
  }
}
