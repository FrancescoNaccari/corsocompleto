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

        //
        System.out.println("inserisci il numero");
        int x=scanner.nextInt();
        byte pariDisp=pariDispari(x);
        System.out.println(pariDisp);

        //
        System.out.println("inserisci il primo parametro");
        double a1=scanner.nextDouble();
        System.out.println("inserisci il secondo parametro");
        double a2=scanner.nextDouble();
        System.out.println("inserisci il terzo parametro");
        double a3=scanner.nextDouble();
        double area=areaTriangolo(a1,a2,a3);
        System.out.println(area);

    }

    public static double rettangolo(double b1, double h1){
        return (b1+h1)*2;
    }

    public static Byte pariDispari(int num1){
        if (num1%2==0){
            return 0;
        }else {
            return 1;
        }

    }
    public static double areaTriangolo(double a1, double a2, double a3){

        double p=(a1+a2+a3)/2;
        double area=Math.sqrt(p*(p-a1)*(p-a2)*(p-a3));
        return area;

}

}
