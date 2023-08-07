package de.ait.tasktreker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "List of Users")
public class UsersListDto {
  @Schema(description = "Users")
  private List<UserDto> users;

  @Schema(description = "Total number of users", example = "1")
  private Integer count;
}
