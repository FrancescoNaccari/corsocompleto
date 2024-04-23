package it.nextdevs.esercizio1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set elementi=new HashSet();
        Integer elementiN = 0;
        boolean continua;
        do {
            try {
                System.out.println("Numero di elementi da inserire?");
                elementiN = scanner.nextInt();
                if (elementiN <= 0) {
                    throw new Exception();
                }
                continua = true;
            } catch (Exception e) {
                System.out.println("devi inserire numeri interi e maggiore di 0");
                continua = false;
            }
        } while (!continua);
        scanner.nextLine();
        for (int i = 0; i < elementiN; i++) {
            System.out.println("Scrivi la parole che vuoi aggingere - slot " + (i+1));
            String parola = scanner.nextLine();
            if (elementi.add(parola)){
                System.out.println(parola);
            }else {
                System.err.println(parola+ " già esiste");
                i--;
            }
        }

        System.out.println("Risultato: "+ elementi);
    }

}
