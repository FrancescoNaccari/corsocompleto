package entity.mezzi;

import entity.Abbonamento;
import entity.biglietto.Biglietto;

import javax.persistence.*;
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

}
