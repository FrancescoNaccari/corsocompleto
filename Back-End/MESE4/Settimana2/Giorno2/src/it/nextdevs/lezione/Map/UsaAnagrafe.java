package it.nextdevs.lezione.Map;

import it.nextdevs.lezione.Object.Persona;

public class UsaAnagrafe {
    public static void main(String[] args) {
        Anegrafe anegrafe=new Anegrafe();

        Persona p1 =new Persona("gino", "lavatrice",23);
        Persona p2 =new Persona("gina", "lavatrice",24);
        Persona p3 =new Persona("gino", "lava",23);

        anegrafe.aggiungiPersona("GHF547GFGHJF",p1);
        anegrafe.aggiungiPersona("OUUH544jhk4hj",p2);
        anegrafe.aggiungiPersona("OgdsdH544jhk4hj",p3);

        anegrafe.StampaAnagrafe();
        System.out.println("---------------");
        anegrafe.rimuoviPersona("GHF547GFGHJF");
        anegrafe.StampaAnagrafe();

    }
}
