package it.epicode.esercizio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
  Articolo art1=new Articolo("erec","caffe", 2 , 30);
        Articolo art2=new Articolo("ejrec","caffe", 3 , 30);


        Cliente cliente=new Cliente("gino","lino","sdhjkgdsf","asdhk@sds.it","25/05/2021" );


        Carrello carrello = new Carrello(cliente);
        if (carrello.aggiungiArticolo(art1)) {
            System.out.println("Articolo aggiunto con successo");
        } else {
            System.out.println("Errore nell'aggiunta dell'articolo");
        }
        if (carrello.aggiungiArticolo(art1)) {
            System.out.println("Articolo aggiunto con successo");
        } else {
            System.out.println("Errore nell'aggiunta dell'articolo");
        }
        if (carrello.aggiungiArticolo(art1)) {
            System.out.println("Articolo aggiunto con successo");
        } else {
            System.out.println("Errore nell'aggiunta dell'articolo");
        }
        if (carrello.aggiungiArticolo(art2)) {
            System.out.println("Articolo aggiunto con successo");
        } else {
            System.out.println("Errore nell'aggiunta dell'articolo");
        }
        if (carrello.aggiungiArticolo(art2)) {
            System.out.println("Articolo aggiunto con successo");
        } else {
            System.out.println("Errore nell'aggiunta dell'articolo");
        }

        carrello.controllaCarrello();
    }

    }

