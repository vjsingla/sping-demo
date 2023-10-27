package app.domain.controller.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);

        return new ResponseEntity<>(map, status);
    }

    public static ResponseEntity<Object> validationErrorResponse(Object responseObj) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        Map<String, Object> map = new HashMap<>();
        map.put("status", status.value());
        map.put("errors", responseObj);

        return new ResponseEntity<>(map, status);
    }

    public static ResponseEntity<Object> success(Object responseObj) {
        return generateResponse(
                "Success",
                HttpStatus.OK,
                responseObj
        );
    }

    public static ResponseEntity<Object> noContent() {
        return new ResponseEntity<>(
                "",
                HttpStatus.NO_CONTENT
        );
    }

    public static ResponseEntity<Object> notFound() {
        return generateResponse(
                "Entity not found",
                HttpStatus.NOT_FOUND,
                ""
        );
    }

    public static ResponseEntity<Object> serverError() {
        return generateResponse(
                "Internal server error",
                HttpStatus.INTERNAL_SERVER_ERROR,
                ""
        );
    }
}
