package it.epicode.eserciozio2;

import java.util.Arrays;

public class Sim {
    private String numeroTelefono;
    private double creditoDisponibile;
    private Arrays<Chiamata> listaChiamate;

    public Sim(int numeroTelefono, int creditoDisponibile, int listaChiamate) {
        this.numeroTelefono = numeroTelefono;
        this.creditoDisponibile = creditoDisponibile;
        this.listaChiamate = listaChiamate;
    }

}
