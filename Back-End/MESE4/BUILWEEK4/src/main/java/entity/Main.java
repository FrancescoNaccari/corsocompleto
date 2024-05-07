package entity;

import Dao.*;
import entity.biglietto.Biglietto;
import entity.mezzi.Mezzo;
import entity.mezzi.Tratta;
import entity.mezzi.Viaggio;
import enums.TipoAbbonamento;
import enums.TipoMezzo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Main {

        public static void main(String[] args) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("build_week_jpa");
            EntityManager em = emf.createEntityManager();

            BigliettoDao bigliettoDao = new BigliettoDao(em);
            UtenteDao utenteDao = new UtenteDao(em);
            TesseraDao tesseraDao = new TesseraDao(em);
            ViaggioDao viaggioDao=new ViaggioDao(em);
            AbbonamentoDao abbonamentoDao=new AbbonamentoDao(em);
            TrattaDao trattaDao = new TrattaDao(em);
            RivenditoreDao rivenditoreDao = new RivenditoreDao(em);
            ManutenzioneDao manutenzioneDao = new ManutenzioneDao(em);
            DistributoreDao distributoreDao = new DistributoreDao(em);
            MezzoDao mezzoDao = new MezzoDao(em);



            Mezzo mezzoAutobus = new Mezzo();
            mezzoAutobus.setTipoMezzo(TipoMezzo.AUTOBUS);

            Mezzo mezzoTram = new Mezzo();
            mezzoTram.setTipoMezzo(TipoMezzo.TRAM);

            //UTENTE
            Utente utente1=new Utente();
            utente1.setNome("Elena");
            utente1.setCognome("Kekic");
            utente1.setTessera(tesseraDao.getById(1));
            utenteDao.save(utente1);

            //VIAGGIO
            Viaggio viaggio1 = new Viaggio();
            viaggio1.setData(LocalDate.of(2024,5,7));
            viaggio1.setTratta(trattaDao.getById(1));
            viaggio1.setTempoEffettivoPercorrenza(40);
            viaggioDao.save(viaggio1);

            //BIGLIETTI
            Biglietto biglietto1=new Biglietto();
            biglietto1.setCodiceUnivoco("rv");
            biglietto1.setPrezzo(2.2);
            biglietto1.setDataEmissione(LocalDate.of(2024,5,7));
            biglietto1.setUtente(utenteDao.getById(1));
            biglietto1.setViaggio(viaggioDao.getById(1));
            bigliettoDao.save(biglietto1);

            //TRATTA
            Tratta tratta1=new Tratta();
            tratta1.setTempoMedio(20);
            tratta1.setMezzo(mezzoTram);
            tratta1.setCapolinea("Stazione centrale");
            tratta1.setZonaPartenza("Stazione Notarbartolo");
            tratta1.setViaggi(List.of(viaggioDao.getById(1)));
            tratta1.setBiglietto(bigliettoDao.getById(1));
            trattaDao.save(tratta1);

            //TESSERRA
            Tessera tessera1 = new Tessera();
            tessera1.setNumeroTessera("A123456");
            tessera1.setDataEmissione(LocalDate.of(2024, 5, 7));
            tessera1.setDataScadenza(LocalDate.of(2025, 5, 7));
            tesseraDao.save(tessera1);

            //DISTRIBUTORE
            Distributore distributore = new Distributore();
            distributore.setBiglietti(List.of(biglietto1));
            distributore.setAttivo(true);
            distributore.setFuoriServizio(false);
            distributoreDao.save(distributore);


            //RIVENDITORE
            Rivenditore rivenditore = new Rivenditore();
            rivenditore.setBiglietti(List.of(biglietto1));
            rivenditoreDao.save(rivenditore);

            //ABBONAMENTO
            Abbonamento abbonamento1 = new Abbonamento();
            abbonamento1.setTipoAbbonamento(TipoAbbonamento.MENSILE);
            abbonamento1.setCodiceUnivoco("A1523");
            abbonamento1.setDistributore(distributoreDao.getById(1));
            abbonamento1.setPrezzo(70);
            abbonamento1.setDataEmissione(LocalDate.of(2024,5,7));
            abbonamento1.setDataScadenza(LocalDate.of(2024,6,7));
            abbonamento1.setUtente(utenteDao.getById(1));
            abbonamentoDao.save(abbonamento1);


        }
    }


