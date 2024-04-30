package epicode;

import epicode.dao.StudenteDao;
import epicode.entity.Studente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("epicode_jpa");

        EntityManager em= emf.createEntityManager();

        StudenteDao dao= new StudenteDao(em);
        Studente s1=new Studente();
        // s1.setMatricola(4);
        s1.setNome("pino");
        s1.setCognome("lava");
        s1.setIndirizzo("via boh");
        s1.setDataNascita(LocalDate.of(2000,2,20));

        //salvataggio di un studente senza matricola(generata automaticamente da jpa)
        dao.save(s1);
        //estrazione del db di uno studente con una determinata matricola
//        Studente s2= dao.getById(1);
//        System.out.println(s2);
//
//        s2.setIndirizzo("via verdi");
//        //update di un record in tabella
//        dao.save(s2);
//
//        //cancellazione di uno studente
//        dao.delete(s1);
    }
}
