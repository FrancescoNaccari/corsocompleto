package it.epicode;

import java.util.Scanner;

public class Operatori {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("inserisci un numero");
        int x=scanner.nextInt();

        System.out.println("inserisci un altro numero");
        int y= scanner.nextInt();

        scanner.nextLine();
        System.out.println("inserisci una parola");

        String s=scanner.nextLine();
        System.out.println(s);

        System.out.println(x%y);
        //oppure
        int z=x%y;
        System.out.println(z);

        x++; // x=x+1
        System.out.println(x);

        boolean b1=true;
        boolean b2=false;
        System.out.println(b1 && b2);
        System.out.println(b1 || b2);
        System.out.println(!b1);

        somma(5,6);
        System.out.println( somma(5,6));

        int somma= somma(5,6);
        System.out.println(somma);
        concatena("java",22);// già nel metodo aveve la stampa (quindi non c'è bisogno della stampa)


    }

    public static int somma(int a, int b){
        int c =a+b;

        //Math.sqrt()
        return c;
//sdfgfgddfgfgd

    }

public static void concatena(String s, int a){
    System.out.println(s+a);
}

//public static int[]popolaArrey(int[] numeri, String s){}
    //cc

}
