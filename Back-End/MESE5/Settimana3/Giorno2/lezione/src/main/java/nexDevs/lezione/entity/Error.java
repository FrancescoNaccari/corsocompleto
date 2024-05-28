package nexDevs.lezione.entity;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Error {
    private String message;
    private LocalDate dataErrore;
    private HttpStatus statoErrore;
}