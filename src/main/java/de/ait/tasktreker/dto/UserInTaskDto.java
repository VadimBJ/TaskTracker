package de.ait.tasktreker.dto;

import de.ait.tasktreker.models.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "User in task")
public class UserInTaskDto {
  @Schema(description = "User id", example = "1")
  private Long id;

  @Schema(description = "User email", example = "example@mail.com")
  private String email;

  public static UserInTaskDto from(User user) {
    return UserInTaskDto.builder()
        .id(user.getId())
        .email(user.getEmail())
        .build();
  }
}
