package NexDevs.lezione.Lambda;

import java.util.Comparator;

public class Comaratore implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        //o1==o2 restituisce 0
        //se o2 viene prima di o1, restituisce un numero negativo (ordine decrescente)
        //se o1 viene prima di o2, restituisce un numero positivo (ordine crescente)
        return o2.compareTo(o1);
    }
}
