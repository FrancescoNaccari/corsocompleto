package nextDevs.lezione.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudenteDto {

    //@NotNull(message = "Il nome non può essere vuoto")
//    @NotEmpty
    @NotBlank
    @Size(max =30)
    private String nome;
    @NotNull(message = "Il cognome non può essere vuoto")
    @Size(max =30)
    private String cognome;
    private LocalDate dataDiNascita;

    @NotNull(message = "L'aulaId non può essere vuoto")
    private int aulaId;

    @Email( regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")
    @NotNull(message = "La email non può essere vuota")
    private String email;

}
