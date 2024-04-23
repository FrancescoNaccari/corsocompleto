package it.nextdevs.lezione.Set;

import it.nextdevs.lezione.Object.Persona;

import java.util.HashSet;

public class ProvaSet {
    public static void main(String[] args) {

        HashSet<Persona> persone=new HashSet<>();// non accetta doppioni, non mantiene l'ordine di inserimento.
        // non ha i metodi che contenevano gli indici
        Persona p1 =new Persona("gino", "lavatrice",23);
        Persona p2 =new Persona("gina", "lavatrice",24);
        Persona p3 =new Persona("gino", "lava",23);
        Persona p4 =new Persona("pino", "lavatrice",24);
        Persona p5 =new Persona("pino", "lavatrice",24);

        persone.add(p1);
        persone.add(p2);
        persone.add(p3);
        persone.add(p4);



        System.out.println(persone);

        persone.add(p5);
        System.out.println(persone);

        for (Persona p:persone){
            System.out.println(p);
        }


    }
}
