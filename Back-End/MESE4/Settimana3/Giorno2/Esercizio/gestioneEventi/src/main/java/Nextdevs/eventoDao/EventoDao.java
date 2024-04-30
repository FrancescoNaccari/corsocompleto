package Nextdevs.eventoDao;


import Nextdevs.gestioneEventi.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDao {
    private EntityManager em;

    public EventoDao(EntityManager em){
        this.em=em;
    }

    public void save(Evento evento){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(evento);
        et.commit();
    }

    public Evento getById(Integer id){
        return em.find(Evento.class,id);
    }

    public void delete(Evento evento){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(evento);
        et.commit();
    }

}
