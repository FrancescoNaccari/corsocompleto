package singleton;

import java.time.LocalDate;

public class CorsoEpicode {
    private String nome;
    private LocalDate localDate;
    private int numeroMax;
    private String sede;

    private static CorsoEpicode corsoEpicode;

    private CorsoEpicode(String nome, LocalDate localDate, int numeroMax, String sede) {
        this.nome = nome;
        this.localDate = localDate;
        this.numeroMax = numeroMax;
        this.sede = sede;
    }

    //entry point per la creazione del singolo corsoEpicode
    public static CorsoEpicode getInstance() {
        if (corsoEpicode == null) {//verifico se è già presente un oggetto di corsoEpicode
            corsoEpicode = new CorsoEpicode("Back-End", LocalDate.now(),35,"Roma");
        }
        return corsoEpicode;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public int getNumeroMax() {
        return numeroMax;
    }

    public void setNumeroMax(int numeroMax) {
        this.numeroMax = numeroMax;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    @Override
    public String toString() {
        return "CorsoEpicode{" +
                "nome='" + nome + '\'' +
                ", localDate=" + localDate +
                ", numeroMax=" + numeroMax +
                ", sede='" + sede + '\'' +
                '}';
    }
}
