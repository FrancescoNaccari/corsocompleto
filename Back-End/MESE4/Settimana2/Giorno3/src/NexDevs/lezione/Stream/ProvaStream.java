package NexDevs.lezione.Stream;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProvaStream {
    public static void main(String[] args) {

        List<String>lista=List.of("java","javascript","html","html","css","python");
        //
        lista.stream().filter(s->s.length()<5).forEach(s -> System.out.println(s));
        System.out.println("--------");

        lista.stream().limit(3).forEach(s -> System.out.println(s));
        System.out.println("--------");

        //stampo il contenuto dello steam sostituendo ad ogni parola la sua lunghezza
        lista.stream().map(s ->s.length()).forEach(s -> System.out.println(s));;
        System.out.println("--------");

        //stampo il contenuto dello steam eliminando i duplicati
        lista.stream().distinct().forEach(s -> System.out.println(s));
        System.out.println("--------");

        //stampo il contenuto dello steam ordinando le parole in ordine decrescente
        lista.stream().sorted((s1,s2)->s2.compareTo(s1)).forEach(s -> System.out.println(s));
        System.out.println("--------");

        //genero la somma della lunghezza delle stringhe presenti nello steam
        int totale=lista.stream().map(string -> string.length()).reduce(0,(somma,l)->somma+l);
        System.out.println(totale);
        System.out.println("--------");

        //genero la somma della lunghezza delle stringhe che hanno lunghezza <5
        int totale1=lista.stream().map(s->s.length()).filter(l->l<5).reduce(0,(somma,l)->somma+l);
        System.out.println(totale1);
        System.out.println("--------");

        //comcateno tutte le stringhe delle stream con separatore ", " ordinandolo e eliminando i doppioni
        String finale=lista.stream().sorted().distinct().collect(Collectors.joining(", "));
        System.out.println(finale);
        System.out.println("--------");

        //creo un set di lunghezza delle stringhe (il set in autonomia elimina i duplicati)
        Set<Integer> numeri=lista.stream().map(s->s.length() ).collect(Collectors.toSet());
        System.out.println(numeri);
        System.out.println("--------");

        List<String> lista2=List.of("epicode","accenture","byte");
        List<List<String>>lista3=List.of(lista,lista2);

        List<String>listaFinale= lista3.stream().flatMap(list->list.stream()).collect(Collectors.toList());
        System.out.println(listaFinale);


        LocalDate data=LocalDate.now();
        System.out.println(data);

        LocalDate data2=LocalDate.of(2020,5,8);
        System.out.println(data2);

        LocalDate data3=LocalDate.parse("2022-04-21");
        System.out.println(data3);


        System.out.println( data2.isBefore(data));//viene prima?
        System.out.println(data2.isAfter(data));//viene dopo?




    }
}
