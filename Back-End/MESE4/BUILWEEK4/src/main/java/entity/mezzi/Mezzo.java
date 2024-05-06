package entity.mezzi;

import enums.TipoMezzo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mezzi")
public class Mezzo {

    @Id
    @GeneratedValue
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_mezzo")
    private TipoMezzo tipoMezzo;

    @Column(name = "in_servizio")
    private Boolean inServizio;

    private int capienza;

    @OneToMany(mappedBy = "mezzo")
    private List<Viaggio> viaggi;


    @OneToMany(mappedBy = "mezzo")
    private List<Manutenzione> manutenzioni;

    public Mezzo(TipoMezzo tipoMezzo, Boolean inServizio, int capienza, List<Viaggio> viaggi, List<Manutenzione> manutenzioni) {
        this.tipoMezzo = tipoMezzo;
        this.inServizio = inServizio;
        this.capienza = capienza;
        this.viaggi = viaggi;
        this.manutenzioni = manutenzioni;
    }

    public Mezzo() {
    }

    public Integer getId() {
        return id;
    }

    public TipoMezzo getTipoMezzo() {
        return tipoMezzo;
    }

    public void setTipoMezzo(TipoMezzo tipoMezzo) {
        this.tipoMezzo = tipoMezzo;
    }

    public Boolean getInServizio() {
        return inServizio;
    }

    public void setInServizio(Boolean inServizio) {
        this.inServizio = inServizio;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    public List<Viaggio> getViaggi() {
        return viaggi;
    }

    public void setViaggi(List<Viaggio> viaggi) {
        this.viaggi = viaggi;
    }

    public List<Manutenzione> getManutenzioni() {
        return manutenzioni;
    }

    public void setManutenzioni(List<Manutenzione> manutenzioni) {
        this.manutenzioni = manutenzioni;
    }

    @Override
    public String toString() {
        return "Mezzo{" +
                "id=" + id +
                ", tipoMezzo=" + tipoMezzo +
                ", inServizio=" + inServizio +
                ", capienza=" + capienza +
                ", viaggi=" + viaggi +
                ", manutenzioni=" + manutenzioni +
                '}';
    }
}
