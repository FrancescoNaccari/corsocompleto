package Dao;

import entity.biglietto.Biglietto;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BigliettoDao {
    private EntityManager em;

    public BigliettoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Biglietto biglietto){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(biglietto);
        et.commit();
    }

    public Biglietto getById(Integer id){

        return em.find(Biglietto.class,id);
    }

    public void update(Biglietto biglietto){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.merge(biglietto);
        et.commit();
    }

    public List<Biglietto> findAll(){
        return em.createQuery("SELECT b FROM Biglietto b",Biglietto.class).getResultList();
    }

    public void delete(Biglietto biglietto){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(biglietto);
        et.commit();
    }
}
