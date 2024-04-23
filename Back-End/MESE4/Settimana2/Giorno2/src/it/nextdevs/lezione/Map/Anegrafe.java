package it.nextdevs.lezione.Map;

import it.nextdevs.lezione.Object.Persona;

import java.util.HashMap;
import java.util.Set;

public class Anegrafe {
    private HashMap<String, Persona> anagrafe;

    public Anegrafe(){
        anagrafe=new HashMap<String, Persona>();

    }
    public void aggiungiPersona(String cf, Persona persona){
        anagrafe.put(cf,persona);

    }

    public void rimuoviPersona(String cf){
        anagrafe.remove(cf);

    }

    public Persona cercaPerCodiceFiscale(String cf){
        return anagrafe.get(cf);
    }


    public void StampaAnagrafe(){
        Set<String> chiavi=anagrafe.keySet();
        for (String cf:chiavi){
            System.out.println(cf+" "+anagrafe.get(cf));
        }

    }
}
