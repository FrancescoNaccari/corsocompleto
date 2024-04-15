package it.epicode;

import java.util.Scanner;

public class Esercizio2 {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("inserisci la prima stringa");
        String stringa1= scanner.nextLine();
        System.out.println("inserisci la seconda stringa");
        String stringa2= scanner.nextLine();
        System.out.println("inserisci la terza stringa");
        String stringa3= scanner.nextLine();
        String concatOrdinato=concatenazione(stringa1,stringa2,stringa3);
        System.out.println("ordinato: "+ concatOrdinato);

        //metodo semplice
//        String concatIversa=concatenazioneInversa(stringa1,stringa2,stringa3);
//        System.out.println("inversa: "+ concatIversa);

        StringBuilder concatIversa= new StringBuilder(concatOrdinato).reverse();
        System.out.println(concatIversa);
    }

public static String concatenazione(String string1,String string2,String string3){
     return string1+" "+string2+" "+string3;
    }

    public static String concatenazioneInversa(String string1,String string2,String string3){
        return string3+string2+string1;
    }
}
