package Dao;

import entity.Utente;
import entity.biglietto.Abbonamento;
import entity.biglietto.Ticket;
import entity.rivenditori.Distributore;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class TicketDao {

    private EntityManager em;

    public TicketDao(EntityManager em) {
        this.em = em;
    }

    public void save(Ticket ticket) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(ticket);
        et.commit();
    }

    public Ticket getById(Integer id) {

        return em.find(Ticket.class, id);
    }

    public void update(Ticket ticket) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(ticket);
        et.commit();
    }

    //    public List<Ticket> findAll(){
//        return em.createQuery("SELECT a FROM Ticket a",Ticket.class).getResultList();
//    }
    public List<Ticket> findAll() {
        return em.createQuery("SELECT t FROM Ticket t JOIN Abbonamento a ON t.id = a.id JOIN " +
                        "Biglietto b ON t.id = b.id", Ticket.class)
                .getResultList();
    }

    public void delete(Ticket ticket) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(ticket);
        et.commit();
    }


    public Long countTicketsByDistributor(LocalDate startDate, LocalDate endDate, Distributore distributore) {
        Query query = em.createQuery(
                "SELECT COUNT(t) FROM Ticket t " +
                        "WHERE t.distributore = :distributore " +
                        "AND t.dataEmissione BETWEEN :startDate AND :endDate"
        );
        query.setParameter("distributore", distributore);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return (Long) query.getSingleResult();
    }

    public boolean verificaValiditaAbbonamento(String numeroTessera) {
        em.getTransaction().begin();

        // Esegui la query per trovare l'utente con il numero di tessera specificato
        Abbonamento abbonamento = em.createQuery(
                        "SELECT a FROM Abbonamento a JOIN a.utente u WHERE u.tessera = :tessera", Abbonamento.class)
                .setParameter("tessera", numeroTessera)
                .getSingleResult();

        if (abbonamento == null) {
            // Abbonamento non trovato, quindi non è valido
            return false;
        }

        // Verifica la data di scadenza dell'abbonamento per determinare la sua validità
        LocalDate dataScadenza = abbonamento.getDataScadenza();
        LocalDate oggi = LocalDate.now();
        return !oggi.isAfter(dataScadenza); // L'abbonamento è valido se la data attuale non supera la data di scadenza
    }
}

