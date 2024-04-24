package it.nextdevs.esercizio3;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Rubrica rubrica=new Rubrica();

        rubrica.inserisciContatto("gino","7883465");
        rubrica.inserisciContatto("lino","1234565");
        rubrica.inserisciContatto("pino","1520265");

        rubrica.stampaRubrica();


        System.out.println(rubrica.cercaPerNome("gino"));
        System.out.println(rubrica.cercaPerTelefono("1520265"));


    }

}
