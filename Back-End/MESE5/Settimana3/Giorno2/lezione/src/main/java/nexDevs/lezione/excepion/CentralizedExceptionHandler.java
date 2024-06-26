package nexDevs.lezione.excepion;




import nexDevs.lezione.entity.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@RestControllerAdvice
public class CentralizedExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> UserNotFoundhandler(NotFoundException e){
      Error error = new Error();
      error.setMessage(e.getMessage());
      error.setDataErrore(LocalDate.now());
      error.setStatoErrore(HttpStatus.NOT_FOUND);

      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }


  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<Object> badRequestHandler(BadRequestException e){
    Error error = new Error();
    error.setMessage(e.getMessage());
    error.setDataErrore(LocalDate.now());
    error.setStatoErrore(HttpStatus.BAD_REQUEST);

    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }

}
