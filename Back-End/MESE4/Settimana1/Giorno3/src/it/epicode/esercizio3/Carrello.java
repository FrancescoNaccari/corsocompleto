package it.epicode.esercizio3;

import java.util.ArrayList;

public class Carrello {
    private Cliente cliente;
    private ArrayList<Articolo> articoli;
    private double totaleCostoArticoli;

    public Carrello(Cliente cliente) {
        this.cliente = cliente;
        this.articoli = new ArrayList<Articolo>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean aggiungiArticolo(Articolo articolo){
        if (articolo.getNumeroPezzi()>0){
            articolo.setNumeroPezzi(articolo.getNumeroPezzi()-1);
            this.articoli.add(articolo);
            totaleCostoArticoli+=articolo.getPrezzo();
            return true;
        }return false;
    }

    public void controllaCarrello() {
        System.out.println("Carrello di: "+this.cliente.getNome()+ this.cliente.getCognome());
        System.out.println("Articoli carrello:");
        for (Articolo articolo:articoli) {
            System.out.println("-------------------");
            System.out.println("Nome articolo: "+articolo.getDescrizione());
            System.out.println("Prezzo articolo: "+articolo.getPrezzo());
            System.out.println("Quantità disponibile: "+articolo.getNumeroPezzi());
        }
        System.out.println("-----------------------");
        System.out.println("Totale carrello: "+this.totaleCostoArticoli+" euro");
    }

}


