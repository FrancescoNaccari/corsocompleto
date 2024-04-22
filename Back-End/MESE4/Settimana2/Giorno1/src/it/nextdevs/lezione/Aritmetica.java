package it.nextdevs.lezione;

public class Aritmetica {
    public  int divisione(int a, int b) throws DivisionePer0Exception {
        int risultato=0;

        if (b==0){
            throw new DivisionePer0Exception("Divisione per 0 non ammessa");
        }else {
            risultato=a/b;

        }

        return risultato;
    }
}
