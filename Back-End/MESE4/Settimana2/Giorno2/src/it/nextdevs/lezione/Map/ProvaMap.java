package it.nextdevs.lezione.Map;

import it.nextdevs.lezione.Object.Persona;

import java.util.HashMap;
import java.util.Set;

public class ProvaMap {
    public static void main(String[] args) {

        HashMap<String, Persona> anagrafe=new HashMap<>();

        Persona p1 =new Persona("gino", "lavatrice",23);
        Persona p2 =new Persona("gina", "lavatrice",24);
        Persona p3 =new Persona("gino", "lava",23);
        Persona p4 =new Persona("pino", "lavatrice",24);
        Persona p5 =new Persona("pino", "lavatrice",24);

        anagrafe.put("DSDS4654DD",p1);
        anagrafe.put("GGG55gGGfg55g",p2);
        anagrafe.put("DSDS46544D",p3);


        anagrafe.get("DSDS4654DD");// per cercare tramite key (tramite la chiave)
        System.out.println(anagrafe.get("dffdsdfsdfsfd4"));
        System.out.println( anagrafe.get("DSDS4654DD"));

        //anagrafe.replace();//se trovala chiave va a sostituire con la nuova coppia .

        System.out.println("------------------------");
        //cercare il codice fiscale collegato a p2
        Set<String > codiceFiscali=anagrafe.keySet();//restituisce il set delle chiavi(ovvere tutte le chiavi)

        for (String chiave:codiceFiscali){
           Persona p= anagrafe.get(chiave);
           if (p.equals(p2)){
               System.out.println(chiave);
           }


        }
    }
}
