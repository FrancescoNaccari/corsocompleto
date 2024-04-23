package it.nextdevs.lezione.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProvaList {
    public static void main(String[] args) {


        ArrayList<String> lista=new ArrayList<>(); //è piu veloce per la ricerca delle posizioni
        lista.add("5");
        lista.add("hellooo");
        lista.add("true");

        System.out.println(lista.get(0));

        System.out.println(lista);

        lista.set(1,"java");// per modificare la lista(posizione, nuovo valore)
        System.out.println(lista);

        lista.size();//per sappere la dimensione della lista
        System.out.println(lista.size());

        lista.remove("java");//per rimuovere/eliminare un singolo elemento con lo stesso nome(si inserisce la stringa da eliminare , rimuove solo il primo che trova )
        System.out.println(lista);


        lista.remove(0);//per rimuovere/eliminare un singolo elemento(si inserisce l'indice da eliminare)
        System.out.println(lista);

       lista.clear();//per pulire/svuotare/eliminare tutto il contenuto




        lista.isEmpty();// per capire se la lista è vuota O NO (ritorna un booleano)

        lista.add("5");
        lista.add("hellooo");
        lista.add("true");
        lista.contains("hellooo");//per capire se c'è un elemento nella lista(tipo una stringa specifica e ritorna un booleano)
        System.out.println(lista.contains("hellooo"));


        lista.add("java");
        lista.indexOf("java");//per conoscere l'indice della stringa/numero/oggetti
        System.out.println(lista.indexOf("java"));

        System.out.println(lista);
        lista.add("javascript");
        lista.add("css");
        lista.add("html");
        System.out.println(lista);

        List.of("java","javascript","html");//per crea una lista rapida per utilizzarla solo dove viene creata

        lista.removeAll(List.of("java","javascript"));// per rimuovere dalla lista tutti gli elementi passati nella lista
        System.out.println(lista);

        System.out.println("-------------------------");
        for (String s:lista){     //for complesso
            System.out.println(s);
        }


        LinkedList<String> lista2=new LinkedList<>(); // è piu veloce nell'aggiungere o togliere elementi (dimensione)

        lista2.poll();//prende il primo elemento e lo elimina dalla lista e lo restituisce per utilizzarlo
        // (tipo get e set(si puo utilizzare anche per spostarlo l'elemento dalla lista ad un'altra))






    }
}
