package it.epicode.esercizio;

public class Main {
    public static void main(String[] args) {


        Dipendente dipendente1=new Dipendente("it01",1220,Dipartimento.VENDITE);
        Dipendente dipendente2=new Dipendente("it02",1720,Dipartimento.PRODUZIONE);
        Dipendente dipendente3=new Dipendente("it03",2220,Dipartimento.AMMINISTRAZIONE);

        Dipendente[] dipendente={dipendente1,dipendente2,dipendente3};
        for (Dipendente dipendenti:dipendente){
            System.out.println("Dipendente "+dipendenti.getMatricola());
        }



    }

}
