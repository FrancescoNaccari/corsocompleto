package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tessera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codice;
    private Date dataEmissione;
    private Date dataScadenza;

    @OneToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
}
