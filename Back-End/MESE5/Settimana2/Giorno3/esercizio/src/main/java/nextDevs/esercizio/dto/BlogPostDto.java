package nextDevs.esercizio.dto;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Duration;

@Data
public class BlogPostDto {

    @NotBlank(message = "Il titolo non può essere vuoto")
    @Size( max = 100)
    private String titolo;
    @NotBlank(message = "Il contenuto non può essere vuoto")
    @Size( max = 10000)
    private String contenuto;
    @NotBlank(message = "La categoria non può essere vuota")
    @Size( max = 100)
    private String categoria;
    @NotNull(message = "Il tempo di lettura non può essere vuoto")
    private Duration tempoDiLettura;


    private int autoreId;
}
