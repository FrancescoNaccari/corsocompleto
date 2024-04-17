package it.epicode.esercizio4;

import java.util.Scanner;

public class Esercizio {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("inserire numero per il conto alla rovescia");
        int n= scanner.nextInt();
          roves(n);
       /* for (int i=n; i>=0; i--){
            System.out.println(i);
        }*/

    }

    public static void roves(int n){
        System.out.println("conto alla rovescia "+ n+ " a 0");
        for (int i=n; i>=0; i--){
            System.out.println(i);
        }
    }

}
