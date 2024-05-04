package NextDevs;

import NextDevs.Dao.CatalogoDao;
import NextDevs.Dao.PrestitoDao;
import NextDevs.Dao.UtenteDao;
import NextDevs.Entity.*;
import NextDevs.Enums.Periodicita;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode_esercizio_progetto_jpa");
        EntityManager em = emf.createEntityManager();


        CatalogoDao catalogoDao=new CatalogoDao(em);
        UtenteDao utenteDao=new UtenteDao(em);
        PrestitoDao prestitoDao=new PrestitoDao(em);

        // Libri
        System.out.println("--------------------------");
        Libro libro1=new Libro();
        libro1.setCodiceISBN("78965412131");
        libro1.setTitolo("Harry Potter e la pietra filosofale");
        libro1.setAnnoPubblicazione(1997);
        libro1.setNumeroPagine(302);
        libro1.setAutore("J.K.Rowling");
        libro1.setGenere("Fantasy");

        try {
            catalogoDao.save(libro1);
            System.out.println("Prodotto salvato con successo");
        }catch (Exception e){
            System.out.println("Prodotto duplicato");
        }


        System.out.println("--------------------------");
        Libro libro2 =new Libro();
        libro2.setCodiceISBN("78964581213");
        libro2.setTitolo("Harry Potter e la camera dei segreti\"");
        libro2.setAnnoPubblicazione(1998);
        libro2.setNumeroPagine(326);
        libro2.setAutore("J.K.Rowling");
        libro2.setGenere("Fantasy");

        try {
            catalogoDao.save(libro2);
            System.out.println("Prodotto salvato con successo");
        }catch (Exception e){
            System.out.println("Prodotto duplicato");
        }


          // RIVISTE
        System.out.println("--------------------------");
        Rivista rivista1=new Rivista();
        rivista1.setCodiceISBN("12657412137");
        rivista1.setTitolo("Motociclismo");
        rivista1.setNumeroPagine(35);
        rivista1.setAnnoPubblicazione( 2024);
        rivista1.setPeriodicita( Periodicita.SETTIMANALE);

        try {
            catalogoDao.save(rivista1);
            System.out.println("Prodotto salvato con successo");
        }catch (Exception e){
            System.out.println("Prodotto duplicato");
        }


        System.out.println("--------------------------");
        try {
            Catalogo catalogo= catalogoDao.getById("125");
            if (catalogo !=null) {
                catalogoDao.delete(catalogo);
                System.out.println("Prodotto eliminato con successo");
            }else {
                throw new RuntimeException("Prodotto non esistente");
            }
        }catch (Exception e){
            System.err.println("Errore: "+e.getMessage());
        }

        try {
            Catalogo catalogo= catalogoDao.getById("78964581213");
            if (catalogo !=null) {
                catalogoDao.delete(catalogo);
                System.out.println("Prodotto eliminato con successo");

            }else {
                throw new RuntimeException("Prodotto non esistente");
            }
        }catch (Exception e){
            System.err.println("Errore: "+e.getMessage());
        }


        Catalogo findCatalogo=catalogoDao.getById("78965412131");
        if (findCatalogo !=null){
            System.out.println(findCatalogo);
        }else {
            System.err.println("Prodotto non esiste");
        }


        //PRODOTTI PER ANNO 1997
        System.out.println("--------------------------");
        List<Catalogo> catalogosByAnno=catalogoDao.findByAnno(1997);
        if (catalogosByAnno.isEmpty()){
            System.out.println("Nessun prodotto trovato per quest'anno ");
        }else {
            catalogosByAnno.forEach(System.out::println);
        }

        //PRODOTTI PER TITOLO
        System.out.println("--------------------------");
        List<Catalogo> catalogosByTitolo=catalogoDao.findByTitolo("Harry");
        if (catalogosByTitolo.isEmpty()){
            System.out.println("Nessun prodotto trovato per titolo");
        }else {
            catalogosByTitolo.forEach(System.out::println);
        }

        System.out.println("--------------------------");
     // Utenti
        Utente utente1=new Utente();
        utente1.setNome("Francesco");
        utente1.setCognome("Naccari");
        utente1.setDataDiNascita(LocalDate.of(1991,05,22));
        try {
            utenteDao.save(utente1);
            System.out.println("Utente salvato correttamente");
        }catch (Exception e){
            System.err.println("Tessera Utente già esistente ");
        }

  System.out.println("--------------------------");
        Utente utente2 =new Utente();
        utente2.setNome("Gino");
        utente2.setCognome("Pino");
        utente2.setDataDiNascita(LocalDate.of(1995,07,12));
        try {
            utenteDao.save(utente2);
            System.out.println("Utente salvato correttamente");
        }catch (Exception e){
            System.err.println("Tessera Utente già esistente ");
        }

  System.out.println("--------------------------");
        Prestito prestito1=new Prestito();
        prestito1.setUtente(utenteDao.getById(1));
        prestito1.setDataInizioPrevisto(LocalDate.now());
        prestito1.setCatalogo(catalogoDao.getById("78965412131"));
        try {
            prestitoDao.save(prestito1);
            System.out.println("Prestito creato con successo");
        }catch (Exception e){
            System.err.println("Errore: "+e.getMessage());
        }

  System.out.println("--------------------------");


        Prestito prestito2 =new Prestito();
        prestito2.setUtente(utenteDao.getById(2));
        prestito2.setDataInizioPrevisto(LocalDate.now());
        prestito2.setCatalogo(catalogoDao.getById("12657412137"));
        try {
            prestitoDao.save(prestito2);
            System.out.println("Prestito creato con successo");
        }catch (Exception e){
            System.err.println("Errore: "+e.getMessage());
        }
        System.out.println("--------------------------");
        List<Catalogo> prodottiPrestito=prestitoDao.getCatalogoFromId(2);
        prodottiPrestito.forEach(System.out::println);
        System.out.println("--------------------------");

        List<Prestito> prestitiNonRestituiti=prestitoDao.getPrestitoScadutoNonConsegnato();
        prestitiNonRestituiti.forEach(System.out::println);

    }
}
