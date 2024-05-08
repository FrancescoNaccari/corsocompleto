package entity;

import Dao.*;
import entity.biglietto.Abbonamento;
import entity.biglietto.Biglietto;
import entity.mezzi.Manutenzione;
import entity.mezzi.Mezzo;
import entity.mezzi.Tratta;
import entity.mezzi.Viaggio;
import entity.rivenditori.Atm;
import entity.rivenditori.Rivenditore;
import enums.TipoAbbonamento;
import enums.TipoMezzo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("build_week_jpa");
        EntityManager em = emf.createEntityManager();

        BigliettoDao bigliettoDao = new BigliettoDao(em);
        UtenteDao utenteDao = new UtenteDao(em);
        TesseraDao tesseraDao = new TesseraDao(em);
        ViaggioDao viaggioDao = new ViaggioDao(em);
        AbbonamentoDao abbonamentoDao = new AbbonamentoDao(em);
        TrattaDao trattaDao = new TrattaDao(em);
        RivenditoreDao rivenditoreDao = new RivenditoreDao(em);
        ManutenzioneDao manutenzioneDao = new ManutenzioneDao(em);
        DistributoreDao distributoreDao = new DistributoreDao(em);
        MezzoDao mezzoDao = new MezzoDao(em);
        TicketDao ticketDao = new TicketDao(em);
        AtmDao atmDao = new AtmDao(em);

        //MEZZI
        //AUTOBUS
        Mezzo mezzoAutobus = new Mezzo();
        mezzoAutobus.setTipoMezzo(TipoMezzo.AUTOBUS);
        mezzoAutobus.setCapienza(30);
        mezzoAutobus.setInServizio(true);
        mezzoDao.save(mezzoAutobus);


        //TRAM
        Mezzo mezzoTram = new Mezzo();
        mezzoTram.setTipoMezzo(TipoMezzo.TRAM);
        mezzoTram.setCapienza(300);
       mezzoTram.setManutenzioni(List.of(manutenzioneDao.getById(4)));
        mezzoTram.setInServizio(false);
        mezzoDao.save(mezzoTram);

        //MANUTENZIONE
        List<Manutenzione> manutenzioni = new ArrayList<>();
        manutenzioni.add(manutenzioneDao.getById(1));

        Manutenzione manutenzione1 = new Manutenzione();
        manutenzione1.setDataInizio(LocalDate.of(2024, 2,4));
        manutenzione1.setDataFine(LocalDate.of(2024,5,12));
        manutenzione1.setMezzo(mezzoTram);
        manutenzioneDao.save(manutenzione1);

        mezzoAutobus.setManutenzioni(manutenzioni);
        mezzoDao.update(mezzoAutobus);



        //VIAGGIO
        Viaggio viaggio1 = new Viaggio();
        List<Viaggio> viaggi = new ArrayList<>();
        viaggi.add(viaggioDao.getById(1));

        viaggio1.setData(LocalDate.of(2024,5,7));
        viaggio1.setTratta(trattaDao.getById(4));
        viaggio1.setTempoEffettivoPercorrenza(40);
        try {
            viaggioDao.save(viaggio1);
            System.out.println("Viaggio aggiunto con successo");
        }catch (Exception e){
            System.out.println("Errore nel salvataggio del viaggio");
        }

        //TRATTA
        Tratta tratta1=new Tratta();
        tratta1.setTempoMedio(20);
        tratta1.setMezzo(mezzoTram);
        tratta1.setCapolinea("Stazione centrale");
        tratta1.setZonaPartenza("Stazione Notarbartolo");
        tratta1.setTicket(abbonamentoDao.getById(11));
        tratta1.setViaggi(List.of(viaggioDao.getById(5)));
        trattaDao.save(tratta1);


        tratta1.setViaggi(viaggi);
        trattaDao.update(tratta1);

        //UTENTE
        Utente utente1=new Utente();
//            List<Utente> utenti = new ArrayList<>();
//            utenti.add(utenteDao.getById(1));

        utente1.setNome("Elena");
        utente1.setCognome("Kekic");
        utente1.setTessera(tesseraDao.getById("A123456"));
        utenteDao.save(utente1);


        //BIGLIETTI
        Biglietto biglietto1=new Biglietto();
        List<Biglietto> biglietti = new ArrayList<>();
        biglietti.add(bigliettoDao.getById(1));
        biglietto1.setCodiceUnivoco("rv");
        biglietto1.setPrezzo(2.2);
        biglietto1.setDataEmissione(LocalDate.of(2024,5,7));
        biglietto1.setVidimato(true);
        //biglietto1.setMezzo(mezzoAutobus);
     //   biglietto1.setUtente(utenteDao.getById(6));
        biglietto1.setDistributore(atmDao.getById(14));
        ticketDao.save(biglietto1);



        //TESSERRA
        Tessera tessera1 = new Tessera();
        tessera1.setNumeroTessera("A123456");
        tessera1.setDataEmissione(LocalDate.of(2024, 5, 7));
        tessera1.setDataScadenza(LocalDate.of(2025, 5, 7));

        try {
            tesseraDao.save(tessera1);

            System.out.println("Tessera salvato correttamente");
        }catch (Exception e){
            System.err.println("Tessera già esistente ");
        }



        //DISTRIBUTORE
        //ATM
        Atm atm1 = new Atm();
        atm1.setAttivo(true);
        atm1.setFuoriServizio(false);
        try {
            distributoreDao.save(atm1);
            System.out.println("Atm salvato correttamente");
        }catch (Exception e){
            System.err.println("Atm già esistente ");
        }



        //RIVENDITORE
        Rivenditore rivenditore1 = new Rivenditore();
        rivenditore1.setNome("Rivenditore Piazza Garibaldi");
        try {
            distributoreDao.save(rivenditore1);
            System.out.println("Rivenditore salvato correttamente");
        }catch (Exception e){
            System.err.println("Rivenditore già esistente ");
        }



        //ABBONAMENTO
        Abbonamento abbonamento1 = new Abbonamento();;
        abbonamento1.setTipoAbbonamento(TipoAbbonamento.MENSILE);
        abbonamento1.setCodiceUnivoco("A1523");
        abbonamento1.setDistributore(atmDao.getById(9));
        abbonamento1.setPrezzo(70);
        abbonamento1.setDataEmissione(LocalDate.of(2024,5,7));
        abbonamento1.setDataScadenza(LocalDate.of(2024,6,7));
        abbonamento1.setUtente(utenteDao.getById(11));
        try {
            ticketDao.save(abbonamento1);
            System.out.println("Abbonamento salvato correttamente");
        }catch (Exception e){
            System.err.println("Abbonamento già esistente ");
        }


        // Conta il numero totale di biglietti emessi nel periodo specificato
        Long totalTickets = bigliettoDao.countTotalTickets(LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 12, 31));
        System.out.println("Numero totale di biglietti emessi: " + totalTickets);

        // Conta il numero totale di abbonamenti emessi nel periodo specificato
        Long totalSubscriptions = abbonamentoDao.countTotalSubscriptions(LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 12, 31));
        System.out.println("Numero totale di abbonamenti emessi: " + totalSubscriptions);

        // Conta il numero di biglietti emessi dal distributore specificato nel periodo specificato
        Long ticketsByDistributor = ticketDao.countTicketsByDistributor(LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 12, 31), distributoreDao.getById(14));
        System.out.println("Numero di biglietti emessi dal ATM ID " + distributoreDao.getById(14)
                + ": " + ticketsByDistributor);

        // Conta il numero di abbonamenti emessi dal distributore specificato nel periodo specificato
        Long subscriptionsByDistributor = abbonamentoDao.countSubscriptionsByDistributor(LocalDate.of(2024,
                        1, 1),
                LocalDate.of(2024, 12, 31), distributoreDao.getById(15));
        System.out.println("Numero di abbonamenti emessi dal distributore ID " + distributoreDao.getById(15)
                + ": " + subscriptionsByDistributor);

        //controllo valido di un abbonamento
        try {
            boolean abbonamentoValido = ticketDao.verificaValiditaAbbonamento("A123456");
            System.out.println("L'abbonamento è valido? " + abbonamentoValido);
        } catch (Exception e) {
            System.err.println("Errore: "+e.getMessage());
        }
    }
}


