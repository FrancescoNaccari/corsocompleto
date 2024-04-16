package it.epicode.esercizio1;

import java.util.Scanner;

public class Esercizio1 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        System.out.println("inserisci la parola");
        System.out.println();
        String n1= scanner.nextLine();
        Boolean b=pariDispari(n1);
        System.out.println( b);

        System.out.println("inserisci l'anno");
        int anno=scanner.nextInt();

        if (annoBisestile(anno)) {
            System.out.println(anno + " è un anno bisestile.");
        } else {
            System.out.println(anno + " non è un anno bisestile.");
        }

        scanner.close();

    }

    public static boolean pariDispari(String s1){
     int n= s1.split("").length;

     return n%2==0;
    }

    public static boolean annoBisestile(int anno){
        /*if (anno % 4 == 0 || (anno % 100 == 0 && anno % 400 == 0)) {
            return true;
        } else {
            return false;
        }*/
        if (anno%4==0){
            return true;
        } else if (anno%100==0) {
            return anno % 400==0;
        }return false;

    }

}
