package nextDevs.lezione.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Studente {
    @Id
    @GeneratedValue
    private int matricola;
    //variabile statica per mantenere un valore comune per tutti gli studenti
//    private static int cont;
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;

    private String foto;
private String email;
    @ManyToOne
    @JoinColumn(name = "aula_id")
    @JsonIgnore
    private Aula aula;



//    public Studente(String nome, String cognome, LocalDate dataDiNascita) {
//        this.nome = nome;
//        this.cognome = cognome;
//        this.dataDiNascita = dataDiNascita;
//        cont++;//incremento cont che essendo statica viene incrementato in ogni oggetto della classe
//       matricola = cont;//matricola prendera il valore in cont , il passaggio è per valore.
//        //matricola non è statica e quindi è indipendente da oggetto ad oggetto. il suo valore
//        // cambia se il valore di cont cambia successivamente
//
//    }




}
