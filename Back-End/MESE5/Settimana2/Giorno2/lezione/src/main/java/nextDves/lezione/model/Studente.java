package nextDves.lezione.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Studente {
    private int matricola;
    //variabile statica per mantenere un valore comune per tutti gli studenti
    private static int cont;
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;

    public Studente(String nome, String cognome, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        cont++;//incremento cont che essendo statica viene incrementato in ogni oggetto della classe
        matricola = cont;//matricola prendera il valore in cont , il passaggio è per valore.
        //matricola non è statica e quindi è indipendente da oggetto ad oggetto. il suo valore
        // cambia se il valore di cont cambia successivamente

    }
}
