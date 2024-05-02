package Nextdevs.gestioneEventi;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="eventi")
public class Evento {

    @Id
    /* @GeneratedValue*/
   // @GeneratedValue(strategy=GenerationType.IDENTITY)

    /* @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "eventi_id_sequence")
    @SequenceGenerator(name="eventi_id_sequence",initialValue = 1,allocationSize = 1)*/

//da usare quando la generation type è SEQUENCE
     @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "eventi_id_table")
    @TableGenerator(name = "eventi_id_table",initialValue = 0,allocationSize = 1)


    private Integer id;
     @Column(name = "titolo")
     private String titolo;
    @Column(name = "data_evento")
    private LocalDate dataEvento;
    private String descrizione;

   @Column(name="tipo_evento")
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    @Column(name="numero_massimo_partecipanti")
   private Integer numeroMassimoPartecipanti;

    @OneToOne
    @JoinColumn(name ="location_id" )
    private Location location;

    @OneToMany(mappedBy = "evento")
    private List <Partecipazione> partecipazioni;

    public Evento( String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, Integer numeroMassimoPartecipanti) {

        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Evento(){}

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Integer getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}
