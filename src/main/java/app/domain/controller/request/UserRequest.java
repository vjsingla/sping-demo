package app.domain.controller.request;

import lombok.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
public class UserRequest {
    @NotBlank(message = "Please provide first name")
    private String firstname;

    @NotBlank(message = "Please provide last name")
    private String lastname;

    @NotBlank(message = "Please provide username")
    private String username;

    @NotBlank(message = "Please provide password")
    private String password;

    @NotBlank(message = "Please provide email")
    @Email(message = "Please provide a valid email")
    private String email;
}
