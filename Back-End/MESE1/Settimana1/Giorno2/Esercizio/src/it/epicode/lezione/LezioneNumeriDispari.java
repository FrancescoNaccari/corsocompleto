package it.epicode.lezione;

import java.util.Scanner;

public class LezioneNumeriDispari {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //    stampaNumeriDispariwhile();
        stampaNumeriDispariDoWhile();
    }

    public static void stampaNumeriDispariwhile() {
        int i = 3;
        //while con 19 iterazioni
       /* while (i<=21){
            if (i%2!=0){
                System.out.println(i);
            }
            i++;
        }*/

        //while con 10 iterazioni
        while (i <= 21) {
            System.out.println(i);
            i = i + 2;


        }

    }


    public static void stampaNumeriDispariFor() {
        for (int i = 3; i <= 21; i++) {
            if (i % 2 != 0) System.out.println(i);

        }

    }


    public  static void stampaNumeriDispariDoWhile(){
        int i =3;
        do {
            if (i%2!=0)
            System.out.println(i);
            i++;
        }while (i<=21);
    }
}