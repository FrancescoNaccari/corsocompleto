package Nextdevs.gestioneEventi;

import Nextdevs.enums.Stato;

import javax.persistence.*;


@Entity
@Table(name = "partecipazioni")
@NamedQuery(name = "getPersonaByEvento",query = "select part.persona from Partecipazione part where part.evento=:evento")
public class Partecipazione {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @Enumerated(EnumType.STRING)
    private Stato stato;



    public Partecipazione( Persona persona, Stato stato,Evento evento) {
      this.evento=evento;
        this.persona = persona;
        this.stato = stato;
    }

    public Partecipazione() {
    }

    public Integer getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public Stato getStato() {
        return stato;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }


    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", stato=" + stato +
                '}';
    }
}
