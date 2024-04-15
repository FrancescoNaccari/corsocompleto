package it.epicode;

import java.util.Scanner;

public class Esercizio3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("inserisci la base");
        double base= scanner.nextDouble();
        System.out.println("inserisci l'altezza");
        double altezza= scanner.nextDouble();
        double perimetro=rettangolo(base,altezza);
        System.out.println(perimetro);
    }

    public static double rettangolo(double b1, double h1){
        return (b1+h1)*2;
    }

//    public static int pariDispari(int num1){
//        if (num1==)
//        return
//    }

}
