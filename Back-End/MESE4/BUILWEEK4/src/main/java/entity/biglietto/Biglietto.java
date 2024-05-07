package entity.biglietto;

import entity.rivenditori.Distributore;
import entity.Utente;
import entity.mezzi.Viaggio;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "biglietti")
public class Biglietto extends Ticket {


    @ManyToOne
    @JoinColumn(name = "viaggio_id")
    private Viaggio viaggio;

    private boolean annullato;


    public Biglietto(String codiceUnivoco, double prezzo, LocalDate dataEmissione, Utente utente, Distributore distributore, Viaggio viaggio, boolean annullato) {
        super(codiceUnivoco, prezzo, dataEmissione, utente, distributore);
        this.viaggio = viaggio;
        this.annullato = annullato;
    }

    public Biglietto() {
        super();
    }

    public Viaggio getViaggio() {
        return viaggio;
    }

    public void setViaggio(Viaggio viaggio) {
        this.viaggio = viaggio;
    }

    public boolean isAnnullato() {
        return annullato;
    }

    public void setAnnullato(boolean annullato) {
        this.annullato = annullato;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "viaggio=" + viaggio +
                ", annullato=" + annullato +
                '}';
    }
}
