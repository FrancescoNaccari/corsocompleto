package Nextdevs.gestioneEventi;

import Nextdevs.enums.Genere;
import Nextdevs.enums.TipoEvento;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
public class Concerto extends Evento{
    @Enumerated(EnumType.STRING)
    private Genere genere;
    private boolean inStraming;

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, Integer numeroMassimoPartecipanti, Genere genere, boolean inStraming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.genere = genere;
        this.inStraming = inStraming;
    }

    public Concerto() {
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStraming() {
        return inStraming;
    }

    public void setInStraming(boolean inStraming) {
        this.inStraming = inStraming;
    }
}
