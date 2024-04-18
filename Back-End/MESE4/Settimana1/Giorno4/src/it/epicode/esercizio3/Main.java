package it.epicode.esercizio3;


public class Main {
    public static void main(String[] args) {
        Dipendente dipendente1=new DipendenteFullTime("it01",1220, Dipartimento.PRODUZIONE,30.3);
        Dipendente dipendente2=new DipendentePartTime("it02",1720, Dipartimento.AMMINISTRAZIONE,15);
    Dipendente dipendente3=new Dirigente("it03",2220, Dipartimento.VENDITE ,10.23);
        Volontario volontario1 = new Volontario("Mario Rossi", 24, "Esperienza nel volontariato presso associazioni ambientaliste");

        DipendenteI[] lavoratori = { dipendente1, dipendente2, dipendente3, volontario1 };

        // Chiamata al metodo checkin per ogni lavoratore
        for (DipendenteI lavoratore : lavoratori) {
            lavoratore.checkIn();
        }

    }
}
