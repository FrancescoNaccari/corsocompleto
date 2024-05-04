package Nextdevs.eventoDao;

import Nextdevs.gestioneEventi.Evento;
import Nextdevs.gestioneEventi.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

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

    public List<Persona>getPersonaByName(String nome){
       Query query= em.createNamedQuery("getPersonaByName");
    query.setParameter("nome",nome);
    return query.getResultList();
    }

    public List<Persona>getPersonaByCognome(String cognome){
       Query query= em.createQuery("select p from Persona p where p.cognome=:cognome");
        query.setParameter("cognome",cognome);
        return query.getResultList();
    }

    public List<Persona>getPersonaByPartName(String nome){
        Query query= em.createQuery("select p from Persona p where p.nome like :nome");
        query.setParameter("nome","%"+nome+"%");
        return query.getResultList();
    }
}
