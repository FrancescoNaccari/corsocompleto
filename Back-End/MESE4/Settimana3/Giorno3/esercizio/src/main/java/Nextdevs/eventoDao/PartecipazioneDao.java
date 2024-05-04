package Nextdevs.eventoDao;

import Nextdevs.gestioneEventi.Evento;
import Nextdevs.gestioneEventi.Partecipazione;
import Nextdevs.gestioneEventi.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class PartecipazioneDao {
    private EntityManager em;

    public PartecipazioneDao(EntityManager em){
        this.em=em;
    }

    public void save(Partecipazione partecipazione){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(partecipazione);
        et.commit();
    }

    public Partecipazione getById(Integer id){
        return em.find(Partecipazione.class,id);
    }

    public void delete(Partecipazione partecipazione){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(partecipazione);
        et.commit();
    }

    public List<Persona> getPersonaByEvento(Evento evento){
        Query query=em.createNamedQuery("getPersonaByEvento");
        query.setParameter("evento",evento);
        return query.getResultList();
    }

    public Long countPersonaByEvento(Evento evento){
        Query query=em.createQuery("select count(part) from Partecipazione part where part.evento=:evento");
        query.setParameter("evento",evento);
        return (Long) query.getSingleResult();
    }

}
