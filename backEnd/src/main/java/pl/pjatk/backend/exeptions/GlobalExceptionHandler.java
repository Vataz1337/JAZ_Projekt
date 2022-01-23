package pl.pjatk.backend.exeptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(GameNotFoundException.class)
    public ResponseEntity<Error> handleNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(GameAlreadyExistsException.class)
    public ResponseEntity<Error> handleBadRequest() {
        return ResponseEntity.badRequest().build();
    }

}
