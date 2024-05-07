package Dao;

import entity.biglietto.Abbonamento;
import entity.biglietto.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class TicketDao {

    private EntityManager em;

    public TicketDao(EntityManager em) {
        this.em = em;
    }

    public void save(Ticket ticket){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(ticket);
        et.commit();
    }

    public Ticket getById(Integer id){

        return em.find(Ticket.class,id);
    }

    public void update(Ticket ticket){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.merge(ticket);
        et.commit();
    }

    public List<Ticket> findAll(){
        return em.createQuery("SELECT a FROM Ticket a",Ticket.class).getResultList();
    }

    public void delete(Ticket ticket){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(ticket);
        et.commit();
    }
}
