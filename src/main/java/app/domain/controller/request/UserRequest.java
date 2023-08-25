package app.domain.controller.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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
