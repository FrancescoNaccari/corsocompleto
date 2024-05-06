package entity;

import enums.TipoAbbonamento;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "abbonamenti")

public class Abbonamento {
    @Id
    @GeneratedValue
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_abbonamento")
    private TipoAbbonamento tipoAbbonamento;

    @Column(name = "codice_univoco")
    private String codiceUnivoco;

    @Column(name = "data_emissione")
    private Date dataEmissione;

    @Column
    private double prezzo;

    @Column(name = "data_scadenza")
    private Date dataScadenza;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "rivenditore_id")
    private Rivenditore rivenditore;

    @ManyToOne
    @JoinColumn(name = "distributore_id")
    private Distributore distributore;



    public Abbonamento() {
    }

    public Abbonamento(TipoAbbonamento tipoAbbonamento, String codiceUnivoco, Date dataEmissione, double prezzo, Date dataScadenza, Utente utente, Rivenditore rivenditore, Distributore distributore) {
        this.tipoAbbonamento = tipoAbbonamento;
        this.codiceUnivoco = codiceUnivoco;
        this.dataEmissione = dataEmissione;
        this.prezzo = prezzo;
        this.dataScadenza = dataScadenza;
        this.utente = utente;
        this.rivenditore = rivenditore;
        this.distributore = distributore;
    }

    public Integer getId() {
        return id;
    }

    public TipoAbbonamento getTipoAbbonamento() {
        return tipoAbbonamento;
    }

    public void setTipoAbbonamento(TipoAbbonamento tipoAbbonamento) {
        this.tipoAbbonamento = tipoAbbonamento;
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

    public Rivenditore getRivenditore() {
        return rivenditore;
    }

    public void setRivenditore(Rivenditore rivenditore) {
        this.rivenditore = rivenditore;
    }

    public Distributore getDistributore() {
        return distributore;
    }

    public void setDistributore(Distributore distributore) {
        this.distributore = distributore;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "id=" + id +
                ", tipoAbbonamento=" + tipoAbbonamento +
                ", codiceUnivoco='" + codiceUnivoco + '\'' +
                ", dataEmissione=" + dataEmissione +
                ", prezzo=" + prezzo +
                ", dataScadenza=" + dataScadenza +
                ", utente=" + utente +
                ", rivenditore=" + rivenditore +
                ", distributore=" + distributore +
                '}';
    }
}
