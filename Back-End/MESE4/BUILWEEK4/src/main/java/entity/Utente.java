package entity;

import entity.biglietto.Biglietto;

import javax.persistence.*;
import java.util.List;


@Entity
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;

    @OneToOne(mappedBy = "utente")
    private Tessera tessera;

    @OneToMany(mappedBy = "utente")
    private List<Biglietto> biglietti;

    @OneToMany(mappedBy = "utente")
    private List<Abbonamento> abbonamenti;

    
    public Utente() {
    }
}
