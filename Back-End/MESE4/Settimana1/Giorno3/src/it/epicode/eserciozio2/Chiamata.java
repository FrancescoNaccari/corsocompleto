package it.epicode.eserciozio2;

public class Chiamata {
    private  int numeroChiamato;
    private int minutiConversazione;

    public Chiamata(int numeroChiamato, int minutiConversazione) {
        this.numeroChiamato = numeroChiamato;
        this.minutiConversazione = minutiConversazione;
    }

    public int getNumeroChiamato() {
        return numeroChiamato;
    }

    public void setNumeroChiamato(int numeroChiamato) {
        this.numeroChiamato = numeroChiamato;
    }

    public int getMinutiConversazione() {
        return minutiConversazione;
    }

    public void setMinutiConversazione(int minutiConversazione) {
        this.minutiConversazione = minutiConversazione;
    }
}
