package Nextdevs;


import Nextdevs.enums.Genere;
import Nextdevs.enums.Sesso;
import Nextdevs.enums.Stato;
import Nextdevs.enums.TipoEvento;
import Nextdevs.eventoDao.EventoDao;
import Nextdevs.eventoDao.LocationDao;
import Nextdevs.eventoDao.PartecipazioneDao;
import Nextdevs.eventoDao.PersonaDao;
import Nextdevs.gestioneEventi.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("epicode_esercizio_jpa");
        EntityManager em=emf.createEntityManager();

        EventoDao eventoDao=new EventoDao(em);
        LocationDao locationDao=new LocationDao(em);
        PartecipazioneDao partecipazioneDao=new PartecipazioneDao(em);
        PersonaDao personaDao=new PersonaDao(em);



//        Evento e1=new Evento();
//
//        e1.setTitolo("Cena aziendale");
//        e1.setDataEvento(LocalDate.of(2024,4,19));
//        e1.setDescrizione("cena");
//        e1.setTipoEvento(TipoEvento.PRIVATO);
//        e1.setNumeroMassimoPartecipanti(50);
//        eventoDao.save(e1);
//
//        Location location=new Location();
//        location.setNome("circo massimo");
//        location.setCitta("roma");
//        locationDao.save(location);
//
//        e1.setLocation(location);
//        eventoDao.save(e1);
//
//
//        Persona persona=new Persona();
//        persona.setNome("gino");
//        persona.setCognome("lino");
//        persona.setEmail("dfgdfgdf@gffd.it");
//        persona.setSesso(Sesso.M);
//
//        personaDao.save(persona);
//
//
//        Persona persona2 =new Persona();
//        persona2.setNome("pino");
//        persona2.setCognome("eeino");
//        persona2.setEmail("dfsdsffsd@gffd.it");
//        persona2.setSesso(Sesso.M);
//
//        personaDao.save(persona2);
//
//
//        Partecipazione partecipazione=new Partecipazione();
//        partecipazione.setEvento(e1);
//        partecipazione.setPersona(persona);
//        partecipazione.setStato(Stato.DA_CONFERMARE);
//
//        partecipazioneDao.save(partecipazione);
//
//        Partecipazione partecipazione2 =new Partecipazione();
//        partecipazione2.setEvento(e1);
//        partecipazione2.setPersona(persona2);
//        partecipazione2.setStato(Stato.DA_CONFERMARE);
//
//        partecipazioneDao.save(partecipazione2);


        personaDao.getPersonaByName("gino").forEach(System.out::println);
        personaDao.getPersonaByCognome("lino").forEach(System.out::println);

        System.out.println("-------------");
        Evento evento=eventoDao.getById(5);
        partecipazioneDao.getPersonaByEvento(evento).forEach(System.out::println);

        System.out.println("-------------");

        System.out.println(partecipazioneDao.countPersonaByEvento(evento));
        System.out.println("-------------");

        personaDao.getPersonaByPartName("o").forEach(System.out::println);



        PartitaDiCalcio partitaDiCalcio=new PartitaDiCalcio();
        partitaDiCalcio.setSquadraCasa("napoli");
        partitaDiCalcio.setSquadraOspite("palermo");
        partitaDiCalcio.setSquadraVincente("palermo");
        partitaDiCalcio.setGolCasa(1);
        partitaDiCalcio.setGolOspite(3);
        partitaDiCalcio.setTipoEvento(TipoEvento.PRIVATO);
        eventoDao.save(partitaDiCalcio);


        Concerto concerto=new Concerto();
        concerto.setGenere(Genere.POP);
        concerto.setInStraming(false);
        eventoDao.save(concerto);

        Query query= em.createQuery("select c from Concerto c where c.inStreaming=:valore");

        Query query2= em.createQuery("select c from Concerto c where c.genere=:valore");

        Query query3= em.createQuery("select p from PartiDiCalcio p where p.golCasa> p.golOspite");

        Query query4= em.createQuery("select g from GaraDiAtletica g where g.vincitore=:persona");



//        Evento e2 =new Evento();
//
//        e2.setTitolo("Riunione aziendale");
//        e2.setDataEvento(LocalDate.of(2024,4,30));
//        e2.setDescrizione("Riunione");
//        e2.setTipoEvento(TipoEvento.PUBBLICO);
//        e2.setNumeroMassimoPartecipanti(50);
//        dao.save(e2);

//        Evento s3=dao.getById(10);
//        System.out.println(s3);
//        s3.setDescrizione("Riunione pubblica");
//        dao.save(s3);


      //  dao.delete(s3);

    }
}
