package entity;

import entity.biglietto.Biglietto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rivdentori")
public class Rivenditore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "rivenditore")
    private List<Abbonamento> abbonamenti;

    @OneToMany(mappedBy = "rivenditore")
    private List<Biglietto> biglietti;


    public Rivenditore(List<Abbonamento> abbonamenti, List<Biglietto> biglietti) {
        this.abbonamenti = abbonamenti;
        this.biglietti = biglietti;
    }

    public Rivenditore() {
    }

    public Integer getId() {
        return id;
    }


    public List<Abbonamento> getAbbonamenti() {
        return abbonamenti;
    }

    public void setAbbonamenti(List<Abbonamento> abbonamenti) {
        this.abbonamenti = abbonamenti;
    }

    public List<Biglietto> getBiglietti() {
        return biglietti;
    }

    public void setBiglietti(List<Biglietto> biglietti) {
        this.biglietti = biglietti;
    }

    @Override
    public String toString() {
        return "Rivenditore{" +
                "id=" + id +
                ", abbonamenti=" + abbonamenti +
                ", biglietti=" + biglietti +
                '}';
    }
}
