package it.epicode.esercizio3;

public class Volontario implements DipendenteI{

    private String nome;
   private int eta;
private String Cv;

    public Volontario(String nome, int eta, String cv) {
        this.nome = nome;
        this.eta = eta;
        Cv = cv;
    }

    @Override
    public void checkIn() {
        System.out.println("Il volontario" + this.nome+"è entrato in servizio");
    }
}
