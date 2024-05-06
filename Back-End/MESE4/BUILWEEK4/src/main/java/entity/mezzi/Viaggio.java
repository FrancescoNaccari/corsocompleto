package entity.mezzi;

import entity.biglietto.Biglietto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "viaggi")
public class Viaggio {
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tratta_id")
    private Tratta tratta;

    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;

    private Date data;

    private Integer tempoEffettivoPercorrenza;

    @OneToMany(mappedBy = "viaggio")
    private List<Biglietto> bigliettiVidimati;

    public Viaggio(Tratta tratta, Mezzo mezzo, Date data, Integer tempoEffettivoPercorrenza, List<Biglietto> bigliettiVidimati) {
        this.tratta = tratta;
        this.mezzo = mezzo;
        this.data = data;
        this.tempoEffettivoPercorrenza = tempoEffettivoPercorrenza;
        this.bigliettiVidimati = bigliettiVidimati;
    }

    public Viaggio() {
    }

    public Integer getId() {
        return id;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getTempoEffettivoPercorrenza() {
        return tempoEffettivoPercorrenza;
    }

    public void setTempoEffettivoPercorrenza(Integer tempoEffettivoPercorrenza) {
        this.tempoEffettivoPercorrenza = tempoEffettivoPercorrenza;
    }

    public List<Biglietto> getBigliettiVidimati() {
        return bigliettiVidimati;
    }

    public void setBigliettiVidimati(List<Biglietto> bigliettiVidimati) {
        this.bigliettiVidimati = bigliettiVidimati;
    }

    @Override
    public String toString() {
        return "Viaggio{" +
                "id=" + id +
                ", tratta=" + tratta +
                ", mezzo=" + mezzo +
                ", data=" + data +
                ", tempoEffettivoPercorrenza=" + tempoEffettivoPercorrenza +
                ", bigliettiVidimati=" + bigliettiVidimati +
                '}';
    }
}
