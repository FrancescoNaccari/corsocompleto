package it.epicode.esercizio3;

import java.util.Scanner;

public class Eserciozio {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String s="";

        do {
            System.out.println("inserisci la stringa (o digita ':q' per uscire)");
            s= scanner.nextLine();
            if (!s.equals(":q")) {
                String[] caratteri = s.split("");
                System.out.println(String.join(",", caratteri));
            }
        }while( !s.equals(":q"));
        scanner.close();
        System.out.println("Fine");



        }



}
