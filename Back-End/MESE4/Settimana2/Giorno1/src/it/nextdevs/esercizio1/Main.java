package it.nextdevs.esercizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Random;
import java.util.Scanner;



public class Main {
    static Logger logger= LoggerFactory.getLogger("logger");
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] array = new int[5];



        for (int i = 0; i < array.length; i++) {
            array[i] =new Random().nextInt(1, 10);
            System.out.println(array[i]);
        }

        int numero = 0;
        int posizione;

        do {
            try {
                System.out.println("Inserisci un numero da 1 a 10");
                numero = scanner.nextInt();

                if (numero >= 1 && numero <= 10) {
                    System.out.println("In quale posizione vuoi inserire il numero? (tra 1 e 5)");
                    posizione = scanner.nextInt();

                    if (posizione >= 1 && posizione <= 5) {
                        array[posizione - 1] = numero;
                        System.out.println("Numero inserito correttamente nella posizione " + posizione);
                    } else {
                        logger.error("Posizione non valida");
                    }
                } else {
                    logger.error("Inserire un numero valido da 1 a 10");
                }
            } catch (Exception e) {
                logger.error("Errore: inserire un numero valido");
                scanner.next();
            }
        } while (numero != 0);

        logger.info("Programma terminato.");


}}
