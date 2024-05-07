package Dao;

import entity.Abbonamento;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class AbbonamentoDao {
    private EntityManager em;

    public AbbonamentoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Abbonamento abbonamento){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(abbonamento);
        et.commit();
    }

    public Abbonamento getById(Integer id){

        return em.find(Abbonamento.class,id);
    }

    public void update(Abbonamento abbonamento){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.merge(abbonamento);
        et.commit();
    }

    public List<Abbonamento> findAll(){
        return em.createQuery("SELECT a FROM Abbonamento a",Abbonamento.class).getResultList();
    }

    public void delete(Abbonamento abbonamento){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(abbonamento);
        et.commit();
    }
}
