package de.ait.tasktreker.dto;

import de.ait.tasktreker.models.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "User")
public class UserDto {

  @Schema(description = "User Id", example = "1")
  private Long id;

  @Schema(description = "User email", example = "example@mail.com")
  private String email;

  @Schema(description = "User role: ADMIN - administrator, USER", example = "ADMIN")
  private String role;

  @Schema(description = "User status: NOT_CONFIRMED, CONFIRMED, BANNED, DELETED", example = "CONFIRMED")
  private String state;

  public static UserDto from(User user) {
    return UserDto.builder()
        .id(user.getId())
        .email(user.getEmail())
        .state(user.getState().name())
        .role(user.getRole().name())
        .build();
  }

  public static List<UserDto> from(List<User> users) {
    return users.stream()
        .map(UserDto::from)
        .collect(Collectors.toList());
  }
}

