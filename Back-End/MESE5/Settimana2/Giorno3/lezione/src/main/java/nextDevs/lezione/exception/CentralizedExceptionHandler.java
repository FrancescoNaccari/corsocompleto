package nextDevs.lezione.exception;


import nextDevs.lezione.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@RestControllerAdvice
public class CentralizedExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(StudenteNonTrovaroException.class)
    public ResponseEntity<Object> StudenteNonTronatohandler(StudenteNonTrovaroException e){
      Error error = new Error();
      error.setMessage(e.getMessage());
      error.setDateErrore(LocalDate.now());
      error.setHttpErrore(HttpStatus.NOT_FOUND);

      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
