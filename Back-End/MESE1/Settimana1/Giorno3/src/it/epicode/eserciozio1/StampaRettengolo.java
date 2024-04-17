package it.epicode.eserciozio1;

import java.util.Scanner;

public class StampaRettengolo {
    public static void main(String[] args) {

        Rettangolo r1=new Rettangolo(12,8);
        r1.perimetro();
        r1.area();
        System.out.println("l'area del primo rettangolo è: "+r1.getArea());
        System.out.println("Il perimetro del primo rettangolo è: "+r1.getPerimetro());

        Rettangolo r2=new Rettangolo(7,14);
        r2.perimetro();
        r2.area();
        System.out.println("\n Il perimetro del secondo rettangolo è: "+r2.getPerimetro());
        System.out.println("l'area del secondo rettangolo è: "+r2.getArea());

        double sommaAree= Rettangolo.sommaAree(r1,r2);
        double sommaPerimetri=Rettangolo.sommaPerimetri(r1,r2);
        System.out.println("\nLa somma delle aree dei due rettangoli è: " + sommaAree);
        System.out.println("La somma dei perimetri dei due rettangoli è: " + sommaPerimetri);
    }




    }



