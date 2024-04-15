package it.epicode;

public class Variabili {
    public static void main(String[] args) {
        int x; //dichiarazione di variabile (int = numeri di tipo intero )
        x=4; //assegnazione di una variabile
        x=6;

        boolean b = true; //dichiarazione ed assegnazione
        char c ='d'; // il char può assumere solo un valore
        double d=3.3;// il double gestisce i numeri con la virgola

        String s="benvenuti al corso epicode";

        String fraseConcatenata=s+" "+(x+4);

        System.out.println(fraseConcatenata);
        final int y=3;

        byte b2=100;

        x=b2; //conversione implicita
        System.out.println(x);
        //b2=x;  // conversione non  ammessa
        x=300;
        b2=(byte) x; // cast esplicito
        System.out.println(b2);

        int[] numeri= new int[6];
        numeri[0]=3;
        numeri[1]=6;
        System.out.println(numeri[1]);

        String[] parole= new String[3];
        parole[0]="corso";
        System.out.println(parole[0]);
        System.out.println(parole[1]);
        System.out.println(parole.length);

        //parole[3]="ciao";

        int[]numeri2={3,5,7};


    }


}
