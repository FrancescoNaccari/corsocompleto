package NexDevs.lezione.Lambda;

import java.util.TreeSet;

public class ProvaLambda3 {
    public static void main(String[] args) {
        TreeSet<String> parole = new TreeSet<>((o1,o2)->(o2.compareTo(o1)) );

        parole.add("java");
        parole.add("html");
        parole.add("css");
        parole.add("javascript");
        System.out.println(parole);

        //stampa di tutti gli elementi del treeset
        parole.forEach(p-> System.out.println(p));

        //equivalente a prima
        for (String s:parole){
            System.out.println(s);
        }
       // il metodo removeIf accetta una espressione lambda nella quale inseriamo
       // la condizione per la quale rimuovere una parola nel Treeset
        parole.removeIf(s-> s.contains("j"));
        System.out.println(parole);


        parole.removeIf(s->{if (s.length()%2==0)
            return true;
            else
                return false;});

        parole.forEach(s->{
            s=s+"!";
            System.out.println(s);
        });



    }
}
