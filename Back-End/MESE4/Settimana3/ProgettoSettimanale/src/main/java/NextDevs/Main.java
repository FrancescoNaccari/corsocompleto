package NextDevs;

import NextDevs.Dao.CatalogoDao;
import NextDevs.Dao.LibroDao;
import NextDevs.Dao.RivistaDao;
import NextDevs.Entity.Catalogo;
import NextDevs.Entity.Libro;
import NextDevs.Entity.Rivista;
import NextDevs.Enums.Periodicita;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode_esercizio_progetto_jpa");
        EntityManager em = emf.createEntityManager();

        LibroDao libroDao=new LibroDao(em);
        CatalogoDao catalogoDao=new CatalogoDao(em);
        RivistaDao rivistaDao=new RivistaDao(em);


        Libro libro1=new Libro();
        libro1.setCodiceISBN("78965412131");
        libro1.setTitolo("Harry Potter e la pietra filosofale");
        libro1.setAnnoPubblicazione(LocalDate.of(1997,6,26));
        libro1.setNumeroPagine(302);
        libro1.setAutore("J.K.Rowling");
        libro1.setGenere("Fantasy");

        try {
            catalogoDao.save(libro1);
            System.out.println("Prodotto salvato con successo");
        }catch (Exception e){
            System.out.println("Prodotto duplicato");
        }



//        Libro libro2 =new Libro();
//        libro2.setCodiceISBN("78964581213");
//        libro2.setTitolo("Harry Potter e la camera dei segreti\"");
//        libro2.setAnnoPubblicazione(LocalDate.of(1998,7,2));
//        libro2.setNumeroPagine(326);
//        libro2.setAutore("J.K.Rowling");
//        libro2.setGenere("Fantasy");
//
//        try {
//            catalogoDao.save(libro2);
//            System.out.println("Prodotto salvato con successo");
//        }catch (Exception e){
//            System.out.println("Prodotto duplicato");
//        }
//


//        Rivista rivista1=new Rivista();
//        rivista1.setCodiceISBN("12657412137");
//        rivista1.setTitolo("Motociclismo");
//        rivista1.setNumeroPagine(35);
//        rivista1.setAnnoPubblicazione(  LocalDate.of(2024,4,26));
//        rivista1.setPeriodicita( Periodicita.SETTIMANALE);
//
//        try {
//            catalogoDao.save(rivista1);
//            System.out.println("Prodotto salvato con successo");
//        }catch (Exception e){
//            System.out.println("Prodotto duplicato");
//        }





        

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





//
//        try {
//        archivio.aggiungiProdotto(new Libro("78965412131","Harry Potter e la pietra filosofale",
//                LocalDate.of(1997,6,26),302,"J.K.Rowling","Fantasy"));
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//       try {
//        archivio.aggiungiProdotto(new Libro("78964581213","Harry Potter e la camera dei segreti",
//                LocalDate.of(1998,7,2),326,"J.K.Rowling","Fantasy"));
//       } catch (Exception e) {
//           System.err.println(e.getMessage());
//       }
//       try {
//        archivio.aggiungiProdotto(new Libro("77898542213","Harry Potter e il prigioniero di azkaban",
//                LocalDate.of(1999,7,8),396,"J.K.Rowling","Fantasy"));
//       } catch (Exception e) {
//           System.err.println(e.getMessage());
//       }
//       try {
//        archivio.aggiungiProdotto(new Libro("77898515634","Harry Potter e il calice di fuoco",
//                LocalDate.of(2000,7,8),655,"J.K.Rowling","Fantasy"));
//       } catch (Exception e) {
//           System.err.println(e.getMessage());
//       }
//       try {
//        archivio.aggiungiProdotto(new Libro("77898576351","Harry potter e l'ordine della fenice",
//                LocalDate.of(2003,6,21),853,"J.K.Rowling","Fantasy"));
//       } catch (Exception e) {
//           System.err.println(e.getMessage());
//       }
//       try {
//        archivio.aggiungiProdotto(new Libro("77898547625","Harry potter e il principe mezzosangue",
//                LocalDate.of(2005,7,16),576,"J.K.Rowling","Fantasy"));
//       } catch (Exception e) {
//           System.err.println(e.getMessage());
//       }
//       try {
//        archivio.aggiungiProdotto(new Libro("77898547777","Harry potter e i doni della morte ",
//                LocalDate.of(2007,7,21),656,"J.K.Rowling","Fantasy"));
//       } catch (Exception e) {
//           System.err.println(e.getMessage());
//       }
//       try {
//        archivio.aggiungiProdotto(new Libro("77898547512","Harry potter e la maledizione dell'erede",
//                LocalDate.of(2016,7,30),353,"J.K.Rowling","Fantasy"));
//       } catch (Exception e) {
//           System.err.println(e.getMessage());
//       }
//
//
//       //RIVISTE
//        try {
//        archivio.aggiungiProdotto(new Rivista("12657412137","Motociclismo",
//                LocalDate.of(2024,4,26),35, Periodicita.SETTIMANALE));
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//        try {
//        archivio.aggiungiProdotto(new Rivista("32657478367","Focus",
//                LocalDate.of(2024,3,15),30,Periodicita.MENSILE));
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//        try {
//        archivio.aggiungiProdotto(new Rivista("33787412687","Panorama",
//                LocalDate.of(2024,1,26),60,Periodicita.SETTIMANALE));
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//
//        System.out.println("----------------------------------");
//
//        try {
//            archivio.rimuoviProdotto("77898547512");
//            System.out.println("Rimozione avvenuta con successo");
//        } catch (Exception e) {
//            System.err.println("Errore: "+e.getMessage());
//        }

//        System.out.println("----------------------------------");
//        System.out.println("Ricerca per ISBN: "+archivio.cercaPerISBN("7896541213"));
//        List<Catalogo> prodottiAnno2024 = archivio.ricercaPerAnnoPubblicazione(LocalDate.of(2000, 1,
//                1));
//
//        System.out.println("----------------------------------");
//        System.out.println("Catalogo 2024:");
//        prodottiAnno2024.forEach(System.out::println);
//
//
//        System.out.println("----------------------------------");
//        List<Catalogo> ricercaAutore=archivio.cercaPerAutore("J.K.Rowling");
//        System.out.println("Libri di J.K.Rowling");
//        ricercaAutore.forEach(System.out::println);
//        System.out.println("----------------------------------");
//
//        try {
//            archivio.salvaSulDisco("archivioDati.txt");
//            System.out.println("File salvato con successo ");
//        }catch (IOException e){
//            System.out.println("Errore nel salvataggio del file");
//        }
//        System.out.println("----------------------------------");
//        try {
//            List<Catalogo> archivioCaricato=archivio.caricamentoSulDisco("archivioDati.txt");
//            System.out.println("Archivio caricato da disco:");
//            archivioCaricato.forEach(System.out::println);
//            System.out.println("File caricato con successo ");
//        } catch (IOException e) {
//            System.out.println("Errore nel caricamento del file");
//        }
    }
}
