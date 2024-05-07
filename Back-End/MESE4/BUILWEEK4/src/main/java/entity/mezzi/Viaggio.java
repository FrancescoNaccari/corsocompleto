package entity.mezzi;

import entity.biglietto.Biglietto;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "viaggi")
public class Viaggio {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tratta_id")
    private Tratta tratta;



    private LocalDate data;

    private Integer tempoEffettivoPercorrenza;

    @OneToMany(mappedBy = "viaggio")
    private List<Biglietto> bigliettiVidimati;

    public Viaggio(Tratta tratta,  LocalDate data, Integer tempoEffettivoPercorrenza, List<Biglietto> bigliettiVidimati) {
        this.tratta = tratta;

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


    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
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

                ", data=" + data +
                ", tempoEffettivoPercorrenza=" + tempoEffettivoPercorrenza +
                ", bigliettiVidimati=" + bigliettiVidimati +
                '}';
    }
}
