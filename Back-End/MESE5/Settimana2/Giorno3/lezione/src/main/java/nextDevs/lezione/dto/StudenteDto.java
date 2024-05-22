package nextDevs.lezione.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudenteDto {

    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;

    private int aulaId;
}
