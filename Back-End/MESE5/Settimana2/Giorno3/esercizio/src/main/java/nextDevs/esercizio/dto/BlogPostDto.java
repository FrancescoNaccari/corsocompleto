package nextDevs.esercizio.dto;

import lombok.Data;

import java.time.Duration;

@Data
public class BlogPostDto {
    private String titolo;
    private String contenuto;
    private String categoria;
    private Duration tempoDiLettura;

    private int autoreId;
}
