package it.nextdevs.lezione.Object;

public class UsaPersona {
    public static void main(String[] args) {

        Persona p1 =new Persona("gino", "lavatrice",23);
        Persona p2 =new Persona("gino", "lavatrice",23);
        System.out.println(p1);
        System.out.println(p2);

        System.out.println(p1.equals(p2));//.equals funziona solo per le stringhe per confrontarle se sono uguali e restituisce un booleano.
        //  però si pou fare l'override si può utilizzare per il confronto

        System.out.println(p1==p2);

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());





    }
}
