package it.epicode.esercizio3;

public class Articolo {
    private String codiceArticolo;
    private String descrizioneArticolo;
    private double prezzo;
    private int disponibilitaMagazziono;


    public Articolo(String codiceArticolo, String descrizioneArticolo, double prezzo, int disponibilitaMagazziono) {
        this.codiceArticolo = codiceArticolo;
        this.descrizioneArticolo = descrizioneArticolo;
        this.prezzo = prezzo;
        this.disponibilitaMagazziono = disponibilitaMagazziono;
    }

    public String getCodiceArticolo() {
        return codiceArticolo;
    }

    public void setCodiceArticolo(String codiceArticolo) {
        this.codiceArticolo = codiceArticolo;
    }

    public String getDescrizioneArticolo() {
        return descrizioneArticolo;
    }

    public void setDescrizioneArticolo(String descrizioneArticolo) {
        this.descrizioneArticolo = descrizioneArticolo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getDisponibilitaMagazziono() {
        return disponibilitaMagazziono;
    }

    public void setDisponibilitaMagazziono(int disponibilitaMagazziono) {
        this.disponibilitaMagazziono = disponibilitaMagazziono;
    }
}
