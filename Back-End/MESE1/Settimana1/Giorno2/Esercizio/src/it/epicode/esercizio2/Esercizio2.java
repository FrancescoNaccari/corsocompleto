package it.epicode.esercizio2;

import java.util.Scanner;

public class Esercizio2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("inserisci il numero");
        int n= scanner.nextInt();

        System.out.println(controllo(n));


    }

    public static String controllo(int n){
        return switch (n) {
            case 0 -> "zero";
            case 1 -> "uno";
            case 2 -> "due";
            case 3 -> "tre";
            default -> "errore , il numero non è compreso tra 0 e 3";
        };

    }
}
