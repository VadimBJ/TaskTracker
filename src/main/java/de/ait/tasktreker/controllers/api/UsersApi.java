package de.ait.tasktreker.controllers.api;

import de.ait.tasktreker.dto.NewUserDto;
import de.ait.tasktreker.dto.UsersListDto;
import de.ait.tasktreker.dto.UserDto;
import de.ait.tasktreker.validation.dto.ValidationErrorsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tags(value = {
    @Tag(name = "Users")
})
public interface UsersApi {

  @Operation(summary = "Adding a new user", description = "Only admin allowed")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "user successfully added",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
          }),
      @ApiResponse(responseCode = "400", description = "Validation error",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorsDto.class))
          })
  })
  @PostMapping("/api/users")
  @ResponseStatus(HttpStatus.CREATED)
  ResponseEntity<UserDto> addUser(@Parameter(required = true, description = "User") @RequestBody @Valid NewUserDto newUser);

  @Operation(summary = "Get users list", description = "Everyone allowed")
  @GetMapping("/api/users")
  ResponseEntity<UsersListDto> getAllUsers();

}
