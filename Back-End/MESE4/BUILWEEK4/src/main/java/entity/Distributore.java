package entity;

import entity.biglietto.Biglietto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "distributori")
public class Distributore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean attivo;
    @Column(name = "fuori_servizio")
    private boolean fuoriServizio;

    @OneToMany(mappedBy = "distributore")
    private List<Abbonamento> abbonamenti;

    @OneToMany(mappedBy = "distributore")
    private List<Biglietto> biglietti;

    public Distributore(boolean attivo, boolean fuoriServizio, List<Abbonamento> abbonamenti, List<Biglietto> biglietti) {
        this.attivo = attivo;
        this.fuoriServizio = fuoriServizio;
        this.abbonamenti = abbonamenti;
        this.biglietti = biglietti;
    }

    public Distributore() {
    }

    public Integer getId() {
        return id;
    }


    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    public boolean isFuoriServizio() {
        return fuoriServizio;
    }

    public void setFuoriServizio(boolean fuoriServizio) {
        this.fuoriServizio = fuoriServizio;
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
        return "Distributore{" +
                "id=" + id +
                ", attivo=" + attivo +
                ", fuoriServizio=" + fuoriServizio +
                ", abbonamenti=" + abbonamenti +
                ", biglietti=" + biglietti +
                '}';
    }
}
