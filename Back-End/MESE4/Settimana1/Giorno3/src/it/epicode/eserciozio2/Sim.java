package it.epicode.eserciozio2;

public class Sim {
    private int numero;
    private double credito;
    private Chiamata[] chiamata;

    public Sim(int numero) {
        this.numero = numero;
    }

    public int getNumeroTelefono() {
        return numero;
    }

    public void setNumeroTelefono(int numero) {
        this.numero = numero;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public Chiamata[] getChiamata() {
        return chiamata;
    }

    public void setChiamata(Chiamata[] chiamata) {
        this.chiamata = chiamata;
    }

    public void stampaDatiSim() {
        System.out.println("Il numero di telefono è " + numero);
        System.out.println("Il credito residuo è " + credito);


        for (int i = 0; i < chiamata.length; i++) {
            System.out.println("Il numero chiamato è " + chiamata[i].getNumeroChiamato() +
                    ", i minuti di conversazione sono " + chiamata[i].getMinutiConversazione());
        }
    }
}
