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

}
