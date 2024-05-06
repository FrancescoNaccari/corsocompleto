package entity.biglietto;

import entity.Utente;
import entity.mezzi.Viaggio;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "biglietti")
public class Biglietto {
    @Id
    @GeneratedValue
    private Integer id;

    @Column( name = "codice_univoco")
    private String codiceUnivoco;

    @Column( name = "data_emissione")
    private Date dataEmissione;

    @Column
    private double prezzo;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;


    @ManyToOne
    @JoinColumn(name = "viaggio_id")
    private Viaggio viaggio;

    private boolean annullato;




    public Biglietto() {
    }

    public Biglietto(String codiceUnivoco, Date dataEmissione, double prezzo, Utente utente, Viaggio viaggio, boolean annullato) {
        this.codiceUnivoco = codiceUnivoco;
        this.dataEmissione = dataEmissione;
        this.prezzo = prezzo;
        this.utente = utente;
        this.viaggio = viaggio;
        this.annullato = annullato;
    }

    public Integer getId() {
        return id;
    }



    public String getCodiceUnivoco() {
        return codiceUnivoco;
    }

    public void setCodiceUnivoco(String codiceUnivoco) {
        this.codiceUnivoco = codiceUnivoco;
    }

    public Date getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(Date dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
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
                "id=" + id +
                ", codiceUnivoco='" + codiceUnivoco + '\'' +
                ", dataEmissione=" + dataEmissione +
                ", prezzo=" + prezzo +
                ", utente=" + utente +
                ", viaggio=" + viaggio +
                ", annullato=" + annullato +
                '}';
    }
}
