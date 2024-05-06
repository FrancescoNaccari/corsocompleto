package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tessere")

public class Tessera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_tessera")
    private String numeroTessera;
    @Column(name = "data_emissione")
    private Date dataEmissione;
    @Column(name = "data_scadenza")
    private Date dataScadenza;

    @OneToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;


    public Tessera(String numeroTessera, Date dataEmissione, Date dataScadenza, Utente utente) {
        this.numeroTessera = numeroTessera;
        this.dataEmissione = dataEmissione;
        this.dataScadenza = dataScadenza;
        this.utente = utente;
    }

    public Tessera() {
    }

    public String getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(String numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public Date getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(Date dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Tessera{" +
                "numeroTessera='" + numeroTessera + '\'' +
                ", dataEmissione=" + dataEmissione +
                ", dataScadenza=" + dataScadenza +
                ", utente=" + utente +
                '}';
    }
}
