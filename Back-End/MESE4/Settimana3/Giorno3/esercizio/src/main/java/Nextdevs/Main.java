package Nextdevs;


import Nextdevs.eventoDao.EventoDao;
import Nextdevs.eventoDao.LocationDao;
import Nextdevs.eventoDao.PartecipazioneDao;
import Nextdevs.eventoDao.PersonaDao;
import Nextdevs.gestioneEventi.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("epicode_esercizio_jpa");
        EntityManager em=emf.createEntityManager();

        EventoDao eventoDao=new EventoDao(em);
        LocationDao locationDao=new LocationDao(em);
        PartecipazioneDao partecipazioneDao=new PartecipazioneDao(em);
        PersonaDao personaDao=new PersonaDao(em);


        Evento e1=new Evento();

        e1.setTitolo("Cena aziendale");
        e1.setDataEvento(LocalDate.of(2024,4,19));
        e1.setDescrizione("cena");
        e1.setTipoEvento(TipoEvento.PRIVATO);
        e1.setNumeroMassimoPartecipanti(50);
        eventoDao.save(e1);

        Location location=new Location();
        location.setNome("circo massimo");
        location.setCitta("roma");
        locationDao.save(location);

        e1.setLocation(location);
        eventoDao.save(e1);


        Persona persona=new Persona();
        persona.setNome("gino");
        persona.setCognome("lino");
        persona.setEmail("dfgdfgdf@gffd.it");
        persona.setSesso(Sesso.M);

        personaDao.save(persona);


        Persona persona2 =new Persona();
        persona2.setNome("pino");
        persona2.setCognome("eeino");
        persona2.setEmail("dfsdsffsd@gffd.it");
        persona2.setSesso(Sesso.M);

        personaDao.save(persona2);


        Partecipazione partecipazione=new Partecipazione();
        partecipazione.setEvento(e1);
        partecipazione.setPersona(persona);
        partecipazione.setStato(Stato.DA_CONFERMARE);

        partecipazioneDao.save(partecipazione);

        Partecipazione partecipazione2 =new Partecipazione();
        partecipazione2.setEvento(e1);
        partecipazione2.setPersona(persona2);
        partecipazione2.setStato(Stato.DA_CONFERMARE);

        partecipazioneDao.save(partecipazione2);










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
