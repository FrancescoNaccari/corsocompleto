package it.epicode.lezione;

import java.util.Scanner;

public class LezionePeriodoAnno {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("inserisci il numero del mese");
        int mese= scanner.nextInt();

        switch (mese){
            case 9,10,11,12:
                System.out.println("primo trimestre");
                break;
            case 1,2,3,4,5,6:
                System.out.println("secondo pentamestre");
                break;
            case 7,8:
                System.out.println("vacanza estiva");
                break;
            default:
                System.out.println("scelta errata");

        }

    }
}
