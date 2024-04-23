package it.nextdevs.lezione.Set;

import it.nextdevs.lezione.Object.Persona;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

public class ProvaSortedSet {
    public static void main(String[] args) {

        TreeSet<Persona> persone=new TreeSet<>(new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                return o1.getNome().compareTo(o2.getNome());// in ordine alfabetico (utilizzando compareTo)
                                                        // per avere l'ordine inverso basta invertire le variabile
            }
        }
        );//permette di ordinare il contenuto della lista. scarta anche i doppioni
        // (deve avere l'informazione di come ordinare tipo: il metodo Comparetor)

        Persona p1 =new Persona("gino", "lavatrice",23);
        Persona p2 =new Persona("gina", "lavatrice",24);
        Persona p3 =new Persona("gino", "lava",23);
        Persona p4 =new Persona("pino", "lavatrice",24);
        Persona p5 =new Persona("pino", "lavatrice",24);

        persone.add(p1);
        persone.add(p2);
        persone.add(p3);
        persone.add(p4);
        System.out.println(persone.add(p5));

        System.out.println(persone);


    }
}
