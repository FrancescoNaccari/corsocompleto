package entity.mezzi;

import entity.biglietto.Abbonamento;
import entity.biglietto.Biglietto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tratte")
public class Tratta {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "zona_partenza")
    private String zonaPartenza;

    private Integer tempoMedio;

    private String capolinea;

    @OneToOne
    @JoinColumn(name = "biglietto_id")
    private Biglietto biglietto;

    @OneToOne
    @JoinColumn(name = "abbonamento_id")
    private Abbonamento abbonamento;

    @OneToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;

    @OneToMany(mappedBy = "tratta")
    private List<Viaggio> viaggi;

    public Tratta(String zonaPartenza, Integer tempoMedio, String capolinea, Biglietto biglietto, Abbonamento abbonamento, Mezzo mezzo, List<Viaggio> viaggi) {
        this.zonaPartenza = zonaPartenza;
        this.tempoMedio = tempoMedio;
        this.capolinea = capolinea;
        this.biglietto = biglietto;
        this.abbonamento = abbonamento;
        this.mezzo = mezzo;
        this.viaggi = viaggi;
    }

    public Tratta() {
    }

    public Integer getId() {
        return id;
    }

    public String getZonaPartenza() {
        return zonaPartenza;
    }

    public void setZonaPartenza(String zonaPartenza) {
        this.zonaPartenza = zonaPartenza;
    }

    public Integer getTempoMedio() {
        return tempoMedio;
    }

    public void setTempoMedio(Integer tempoMedio) {
        this.tempoMedio = tempoMedio;
    }

    public String getCapolinea() {
        return capolinea;
    }

    public void setCapolinea(String capolinea) {
        this.capolinea = capolinea;
    }

    public Biglietto getBiglietto() {
        return biglietto;
    }

    public void setBiglietto(Biglietto biglietto) {
        this.biglietto = biglietto;
    }

    public Abbonamento getAbbonamento() {
        return abbonamento;
    }

    public void setAbbonamento(Abbonamento abbonamento) {
        this.abbonamento = abbonamento;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public List<Viaggio> getViaggi() {

        if (viaggi != null) {
            return this.viaggi;
        } else {
            System.err.println("Lista viaggi vuota");
            return  new ArrayList<>();
        }

    }

    public void setViaggi(List<Viaggio> viaggi) {


 this.viaggi = viaggi;

    }

    @Override
    public String toString() {
        return "Tratta{" +
                "id=" + id +
                ", zonaPartenza='" + zonaPartenza + '\'' +
                ", tempoMedio=" + tempoMedio +
                ", capolinea='" + capolinea + '\'' +
                ", biglietto=" + biglietto +
                ", abbonamento=" + abbonamento +
                ", mezzo=" + mezzo +
                ", viaggi=" + viaggi +
                '}';
    }
}
