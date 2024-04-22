package it.nextdevs.esercizio2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    static Logger logger= LoggerFactory.getLogger("logger");
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        CalcoConsumo calcoConsumo=new CalcoConsumo();

        double km;
        double litri;

        logger.info("inserisci i km fatti");
        km= scanner.nextDouble();

        logger.info("inserisci i litri");
        litri= scanner.nextDouble();

        try {
            double consumoEffettuato = calcoConsumo.consumo(km, litri);
            logger.info("Il consumo effettuato è di " + consumoEffettuato + " km/litro");
        } catch (DivisionePer0Exception e) {
            logger.error("Errore: " + e.getMessage());
        }
    }

}

