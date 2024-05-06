package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Abbonamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codiceUnivoco;
    private Date dataEmissione;
    private double prezzo;
    private Date dataScadenza;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
}
