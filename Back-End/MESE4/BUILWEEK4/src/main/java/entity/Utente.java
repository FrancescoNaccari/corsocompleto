package entity;

import entity.biglietto.Biglietto;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String cognome;

    @OneToOne
    @JoinColumn(name = "tessera_numero_tessera")
    private Tessera tessera;

    @OneToMany(mappedBy = "utente")
    private List<Biglietto> biglietti;

    @OneToMany(mappedBy = "utente")
    private List<Abbonamento> abbonamenti;



    public Utente() {
    }

    public Utente(String nome, String cognome, Tessera tessera, List<Biglietto> biglietti, List<Abbonamento> abbonamenti) {
        this.nome = nome;
        this.cognome = cognome;
        this.tessera = tessera;
        this.biglietti = biglietti;
        this.abbonamenti = abbonamenti;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    public List<Biglietto> getBiglietti() {
        return biglietti;
    }

    public void setBiglietti(List<Biglietto> biglietti) {
        this.biglietti = biglietti;
    }

    public List<Abbonamento> getAbbonamenti() {
        return abbonamenti;
    }

    public void setAbbonamenti(List<Abbonamento> abbonamenti) {
        this.abbonamenti = abbonamenti;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", tessera=" + tessera +
                ", biglietti=" + biglietti +
                ", abbonamenti=" + abbonamenti +
                '}';
    }
}
