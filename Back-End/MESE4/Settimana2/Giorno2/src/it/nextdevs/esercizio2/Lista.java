package it.nextdevs.esercizio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Lista {
    public static ArrayList numeriCasuali(Integer numero) {
        ArrayList<Integer> lista = new ArrayList<Integer>(numero);
        Random random=new Random();
        for (int i = 0; i < numero; i++) {
            Integer nRandom=random.nextInt(0,101);
            if (!lista.contains(nRandom)){
                lista.add(nRandom);
            }else {
                i--;
            }

       }

        Collections.sort(lista);//per ordinare una lista
        return lista;
    }

}
