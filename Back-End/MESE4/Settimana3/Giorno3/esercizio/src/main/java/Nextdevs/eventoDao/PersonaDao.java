package Nextdevs.eventoDao;

import Nextdevs.gestioneEventi.Evento;
import Nextdevs.gestioneEventi.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDao {
    private EntityManager em;

    public PersonaDao(EntityManager em){
        this.em=em;
    }

    public void save(Persona persona){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(persona);
        et.commit();
    }

    public Persona getById(Integer id){
        return em.find(Persona.class,id);
    }

    public void delete(Persona persona){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(persona);
        et.commit();
    }
}
