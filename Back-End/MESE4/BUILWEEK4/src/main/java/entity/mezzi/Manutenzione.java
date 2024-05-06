package entity.mezzi;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name = "manutenzioni")
public class Manutenzione {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;

    private Date dataInizio;

    private Date dataFine;

    public Manutenzione(Mezzo mezzo, Date dataInizio, Date dataFine) {
        this.mezzo = mezzo;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public Manutenzione() {
    }

    public Integer getId() {
        return id;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    @Override
    public String toString() {
        return "Manutenzione{" +
                "id=" + id +
                ", mezzo=" + mezzo +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                '}';
    }
}
