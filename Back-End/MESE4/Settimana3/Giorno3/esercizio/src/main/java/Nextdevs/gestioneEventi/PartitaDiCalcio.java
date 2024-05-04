package Nextdevs.gestioneEventi;

import Nextdevs.enums.TipoEvento;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class PartitaDiCalcio extends Evento {

    @Column(name = "squadra_casa")
    private String squadraCasa;
    @Column(name = "squadra_ospite")
    private String squadraOspite;
    @Column(name = "squadra_vincente")
    private String squadraVincente;
    @Column(name = "gol_casa")
    private Integer golCasa;
    @Column(name = "gol_ospite")
    private Integer golOspite;

    public PartitaDiCalcio(String squadraCasa, String squadraOspite, String squadraVincente, Integer golCasa, Integer golOspite) {
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.golCasa = golCasa;
        this.golOspite = golOspite;
    }

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, Integer numeroMassimoPartecipanti, String squadraCasa, String squadraOspite, String squadraVincente, Integer golCasa, Integer golOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.golCasa = golCasa;
        this.golOspite = golOspite;
    }

    public PartitaDiCalcio() {
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public Integer getGolCasa() {
        return golCasa;
    }

    public void setGolCasa(Integer golCasa) {
        this.golCasa = golCasa;
    }

    public Integer getGolOspite() {
        return golOspite;
    }

    public void setGolOspite(Integer golOspite) {
        this.golOspite = golOspite;
    }
}
