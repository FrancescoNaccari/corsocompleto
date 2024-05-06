package entity.biglietto;

import entity.Utente;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Biglietto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codiceUnivoco;
    private Date dataEmissione;
    private double prezzo;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

}
