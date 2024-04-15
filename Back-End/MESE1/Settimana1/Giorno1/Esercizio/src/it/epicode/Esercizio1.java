package it.epicode;

import java.util.Arrays;
import java.util.Scanner;

public class Esercizio1 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println( "Digita il primo numero da moltiplicare");
        int num1= scanner.nextInt();

        System.out.println( "Digita il secondo numero da moltiplicare");
        int num2= scanner.nextInt();

        int risultato=moltiplicazione(num1,num2);
        System.out.println( "Risultato: "+risultato);


        scanner.nextLine();
        System.out.println("scrivi una stringa");
        String stringa = scanner.nextLine();
        System.out.println("scrivi un numero intero");
        int  num3=scanner.nextInt();
        String risultato2=concatena(stringa,num3);
        System.out.println( "Risultato2: "+risultato2);

        String[]nuovoArrey=inserisciArray(new String[]{"ciao1","ciao2","ciao3","ciao4","ciao5"},"ciao6");
        System.out.println(Arrays.toString(nuovoArrey));

    }

    public static int moltiplicazione(int num1, int num2){

        return num1 * num2;
    }

    public static String concatena(String stringa, int num){
        return stringa+num;
    }

    public static String[]inserisciArray(String[] array,String string){
//String[]arrayNew= new String[]{array[0],array[1],stringa,array[2],array[3],array[4]};
        String[]arrayNew= new String[array.length+1];
        for(int i=0; i<array.length+1;i++){
            if (i<2){
                arrayNew[i]=array[i];
            } else if (i==2) {
                arrayNew[i]=string;
            }else {
                arrayNew[i]=array[i-1];
            }
        }
        return arrayNew;


    }

}





