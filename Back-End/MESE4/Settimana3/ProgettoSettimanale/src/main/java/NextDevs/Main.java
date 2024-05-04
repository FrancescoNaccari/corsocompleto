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
        System.out.println("Aggiunta prodotti Libri");
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
        libro2.setTitolo("Harry Potter e la camera dei segreti");
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

        System.out.println("--------------------------");

        Libro libro3 =new Libro();
        libro3.setCodiceISBN("77898542213");
        libro3.setTitolo("Harry Potter e il prigioniero di azkaban");
        libro3.setAnnoPubblicazione(1999);
        libro3.setNumeroPagine(396);
        libro3.setAutore("J.K.Rowling");
        libro3.setGenere("Fantasy");

        try {
            catalogoDao.save(libro3);
            System.out.println("Prodotto salvato con successo");
        }catch (Exception e){
            System.out.println("Prodotto duplicato");
        }

        System.out.println("--------------------------");

        Libro libro4 =new Libro();
        libro4.setCodiceISBN("77898515634");
        libro4.setTitolo("Harry Potter e il calice di fuoco");
        libro4.setAnnoPubblicazione(2000);
        libro4.setNumeroPagine(655);
        libro4.setAutore("J.K.Rowling");
        libro4.setGenere("Fantasy");

        try {
            catalogoDao.save(libro4);
            System.out.println("Prodotto salvato con successo");
        }catch (Exception e){
            System.out.println("Prodotto duplicato");
        }

        System.out.println("--------------------------");

        Libro libro5 =new Libro();
        libro5.setCodiceISBN("77898576351");
        libro5.setTitolo("Harry Potter e l'ordine della fenice");
        libro5.setAnnoPubblicazione(2005);
        libro5.setNumeroPagine(853);
        libro5.setAutore("J.K.Rowling");
        libro5.setGenere("Fantasy");

        try {
            catalogoDao.save(libro5);
            System.out.println("Prodotto salvato con successo");
        }catch (Exception e){
            System.out.println("Prodotto duplicato");
        }

        System.out.println("--------------------------");

        Libro libro6 =new Libro();
        libro6.setCodiceISBN("77898547625");
        libro6.setTitolo("Harry Potter e il principe mezzosangue");
        libro6.setAnnoPubblicazione(2005);
        libro6.setNumeroPagine(576);
        libro6.setAutore("J.K.Rowling");
        libro6.setGenere("Fantasy");

        try {
            catalogoDao.save(libro6);
            System.out.println("Prodotto salvato con successo");
        }catch (Exception e){
            System.out.println("Prodotto duplicato");
        }

        System.out.println("--------------------------");

        Libro libro7 =new Libro();
        libro7.setCodiceISBN("77898547777");
        libro7.setTitolo("Harry Potter e i doni della morte");
        libro7.setAnnoPubblicazione(2007);
        libro7.setNumeroPagine(656);
        libro7.setAutore("J.K.Rowling");
        libro7.setGenere("Fantasy");

        try {
            catalogoDao.save(libro7);
            System.out.println("Prodotto salvato con successo");
        }catch (Exception e){
            System.out.println("Prodotto duplicato");
        }

        System.out.println("--------------------------");

        Libro libro8 =new Libro();
        libro8.setCodiceISBN("77898547512");
        libro8.setTitolo("Harry Potter  e la maledizione dell'erede");
        libro8.setAnnoPubblicazione(2016);
        libro8.setNumeroPagine(353);
        libro8.setAutore("J.K.Rowling");
        libro8.setGenere("Fantasy");

        try {
            catalogoDao.save(libro8);
            System.out.println("Prodotto salvato con successo");
        }catch (Exception e){
            System.out.println("Prodotto duplicato");
        }



        // RIVISTE
        System.out.println("--------------------------");
        System.out.println("Aggiunta prodotti Riviste");
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

        Rivista rivista2 =new Rivista();
        rivista2.setCodiceISBN("32657478367");
        rivista2.setTitolo("Focus");
        rivista2.setNumeroPagine(15);
        rivista2.setAnnoPubblicazione( 2024);
        rivista2.setPeriodicita( Periodicita.MENSILE);

        try {
            catalogoDao.save(rivista2);
            System.out.println("Prodotto salvato con successo");
        }catch (Exception e){
            System.out.println("Prodotto duplicato");
        }

        System.out.println("--------------------------");

        Rivista rivista3 =new Rivista();
        rivista3.setCodiceISBN("33787412687");
        rivista3.setTitolo("Panorama");
        rivista3.setNumeroPagine(60);
        rivista3.setAnnoPubblicazione( 2024);
        rivista3.setPeriodicita( Periodicita.SEMESTRALE);

        try {
            catalogoDao.save(rivista3);
            System.out.println("Prodotto salvato con successo");
        }catch (Exception e){
            System.out.println("Prodotto duplicato");
        }




        System.out.println("--------------------------");
        System.out.println("Delete");
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

        //PRODOTTI PER ISBN
        System.out.println("--------------------------");
        System.out.println("Ricerca prodotti per ISBN");

        Catalogo findCatalogo=catalogoDao.getById("78965412131");
        if (findCatalogo !=null){
            System.out.println(findCatalogo);
        }else {
            System.err.println("Prodotto non esiste");
        }

        //PRODOTTI PER AUTORE
        System.out.println("--------------------------");
        System.out.println("Ricerca prodotti per autore");
        List<Catalogo>  findProdottoFromAutore=catalogoDao.findByAutore("Rowling");
        if (findProdottoFromAutore.isEmpty()){
            System.out.println("Nessun risultato trovato");
        }else {
            findProdottoFromAutore.forEach(System.out::println);
        }

        //PRODOTTI PER ANNO 1997
        System.out.println("--------------------------");
        System.out.println("Ricerca prodotti per anno");
        List<Catalogo> catalogosByAnno=catalogoDao.findByAnno(1997);
        if (catalogosByAnno.isEmpty()){
            System.out.println("Nessun prodotto trovato per quest'anno ");
        }else {
            catalogosByAnno.forEach(System.out::println);
        }

        //PRODOTTI PER TITOLO
        System.out.println("--------------------------");
        System.out.println("Ricerca prodotti per titolo");
        List<Catalogo> catalogosByTitolo=catalogoDao.findByTitolo("Harry");
        if (catalogosByTitolo.isEmpty()){
            System.out.println("Nessun prodotto trovato per titolo");
        }else {
            catalogosByTitolo.forEach(System.out::println);
        }


         // UTENTI
        System.out.println("--------------------------");
        System.out.println("Aggiunta di Utenti");
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


        //PRESTITO
        System.out.println("--------------------------");
        System.out.println("Prestiti");
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



        //RICERCA DI PRESTITI CON NUMERO DI TESSERA
        System.out.println("--------------------------");
        System.out.println("RICERCA DI PRESTITI CON NUMERO DI TESSERA");
        List<Catalogo> prodottiPrestito=prestitoDao.getCatalogoFromId(2);
        prodottiPrestito.forEach(System.out::println);


        //RICERCA DI PRESTITI SCADUTI
        System.out.println("--------------------------");
        System.out.println("RICERCA DI PRESTITI SCADUTI");
        List<Prestito> prestitiNonRestituiti=prestitoDao.getPrestitoScadutoNonConsegnato();
        prestitiNonRestituiti.forEach(System.out::println);

    }
}
