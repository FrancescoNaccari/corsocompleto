package nextDevs.lezione.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AulaDto {

    @NotNull(message = "Il nome non può essere vuoto")
    @Size( max = 100)
    private String nome;

    @Max(3)
    @Min(0)
    private int piano;
}
