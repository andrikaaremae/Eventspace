package ee.ttu.eventspace.exception;

import org.springframework.http.HttpStatus;

public class FailedAuthenticationException extends RuntimeException {

    private final String message;
    private final HttpStatus httpStatus;

    public FailedAuthenticationException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
