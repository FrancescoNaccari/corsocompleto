package Nextdevs.eventoDao;

import Nextdevs.gestioneEventi.Evento;
import Nextdevs.gestioneEventi.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
}
