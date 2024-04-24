package NexDevs.lezione.Lambda;

import java.util.TreeSet;

public class ProvaLambda {
    public static void main(String[] args) {
        Comaratore comaratore=new Comaratore();
        TreeSet<String> parole = new TreeSet<>(comaratore);

        parole.add("java");
        parole.add("html");
        parole.add("css");
        parole.add("javascript");
        System.out.println(parole);




    }
}
