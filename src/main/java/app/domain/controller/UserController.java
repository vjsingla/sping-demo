package app.domain.controller;

import app.domain.controller.request.UserRequest;
import app.domain.controller.response.ResponseHandler;
import app.domain.entity.User;
import app.domain.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@Tag(name = "User")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(path = "/users/{id}")
	@Operation(description = "Get a single user object")
	public ResponseEntity<Object> get(@PathVariable UUID id) {
		try {
			User record = userService.findById(id);
			if (record == null) {
				return ResponseHandler.notFound();
			}
			return ResponseHandler.success(record);
		} catch (Exception e) {
			return ResponseHandler.serverError();
		}
	}

	@GetMapping(path="/users")
	public ResponseEntity<Object> list() {
		try {
			return ResponseHandler.success(userService.findAll());
		} catch (Exception e) {
			return ResponseHandler.serverError();
		}
	}

	@PostMapping(path="/users")
	public ResponseEntity<Object> create(@Valid @RequestBody UserRequest user) {
		try {
			User saved = userService.save(user);
			return ResponseHandler.success(saved);
		} catch (Exception e) {
			return ResponseHandler.serverError();
		}
	}

	@DeleteMapping(path = "/users/{id}")
	public ResponseEntity<Object> delete(@PathVariable UUID id) {
		try {
			User record = userService.findById(id);
			if (record == null) {
				return ResponseHandler.notFound();
			}
			userService.deleteById(id);
			return ResponseHandler.noContent();
		} catch (Exception e) {
			return ResponseHandler.serverError();
		}
	}
}