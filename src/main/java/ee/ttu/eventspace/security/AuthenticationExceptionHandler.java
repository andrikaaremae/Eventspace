package ee.ttu.eventspace.security;

import ee.ttu.eventspace.exception.FailedAuthenticationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AuthenticationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FailedAuthenticationException.class)
    public ResponseEntity<Object> handleCustomException(FailedAuthenticationException e,
                                                        WebRequest request) {
        Map<String, Object> response = new HashMap<>();

        response.put("success", "false");
        response.put("message", e.getMessage());

        return new ResponseEntity<>(response, e.getHttpStatus());
    }
}
