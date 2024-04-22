package it.nextdevs.esercizio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        CalcoConsumo calcoConsumo=new CalcoConsumo();

        double km;
        double litri;

        System.out.println("inserisci i km fatti");
        km= scanner.nextDouble();

        System.out.println("inserisci i litri");
        litri= scanner.nextDouble();

        try {
            double consumoEffettuato = calcoConsumo.consumo(km, litri);
            System.out.println("Il consumo effettuato è di " + consumoEffettuato + " km/litro");
        } catch (DivisionePer0Exception e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }

}

