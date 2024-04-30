package Nextdevs;


import Nextdevs.eventoDao.EventoDao;
import Nextdevs.gestioneEventi.Evento;
import Nextdevs.gestioneEventi.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("epicode_esercizio_jpa");
        EntityManager em=emf.createEntityManager();

        EventoDao dao=new EventoDao(em);
        Evento e1=new Evento();

        e1.setTitolo("Cena aziendale");
        e1.setDataEvento(LocalDate.of(2024,4,19));
        e1.setDescrizione("cena");
        e1.setTipoEvento(TipoEvento.PRIVATO);
        e1.setNumeroMassimoPartecipanti(50);
        dao.save(e1);

        Evento e2 =new Evento();

        e2.setTitolo("Riunione aziendale");
        e2.setDataEvento(LocalDate.of(2024,4,30));
        e2.setDescrizione("Riunione");
        e2.setTipoEvento(TipoEvento.PUBBLICO);
        e2.setNumeroMassimoPartecipanti(50);
        dao.save(e2);

        Evento s3=dao.getById(10);
        System.out.println(s3);
        s3.setDescrizione("Riunione pubblica");
        dao.save(s3);


      //  dao.delete(s3);

    }
}
