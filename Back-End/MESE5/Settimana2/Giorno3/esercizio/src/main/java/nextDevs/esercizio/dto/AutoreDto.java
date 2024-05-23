package nextDevs.esercizio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AutoreDto {
    @NotBlank(message = "Il nome non può essere vuoto")
    @Size(max =30)
    private String nome;
    @NotBlank(message = "Il cognome non può essere vuoto")
    @Size(max =30)
    private String cognome;

    @NotBlank(message = "L'email non può essere vuoto")
    @Email //( regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")
    @Size(max =30)
    private String email;

    @NotNull
    private LocalDate dataDiNascita;

}
