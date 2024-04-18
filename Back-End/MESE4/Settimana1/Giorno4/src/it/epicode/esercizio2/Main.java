package it.epicode.esercizio2;



public class Main {
    public static void main(String[] args) {
        Dipendente dipendente1=new DipendenteFullTime("it01",1220,Dipartimento.PRODUZIONE,25 );
        Dipendente dipendente2=new DipendentePartTime("it02",1720, Dipartimento.AMMINISTRAZIONE,15);
    Dipendente dipendente3=new Dirigente("it03",2220, Dipartimento.VENDITE );

        Dipendente[] dipendente={dipendente1,dipendente2,dipendente3};
        for (Dipendente dipendenti:dipendente){
            System.out.println("Dipendente "+dipendenti.getMatricola()+" - stipendio "+dipendenti.calculateSalary()+" " +
                    "euro");
        }



    }
}
