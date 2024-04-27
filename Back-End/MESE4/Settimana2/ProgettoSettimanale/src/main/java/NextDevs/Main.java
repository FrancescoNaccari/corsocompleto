package NextDevs;



import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Archivio archivio=new Archivio();
        archivio.aggiungiProdotto(new Libro("78965412131","Harry Potter e la pietra filosofale",
                LocalDate.of(1997,6,26),302,"J.K.Rowling","Fantasy"));

        archivio.aggiungiProdotto(new Libro("78964581213","Harry Potter e la camera dei segreti",
                LocalDate.of(1998,7,2),326,"J.K.Rowling","Fantasy"));

        archivio.aggiungiProdotto(new Libro("77898542213","Harry Potter e il prigioniero di azkaban",
                LocalDate.of(1999,7,8),396,"J.K.Rowling","Fantasy"));

        archivio.aggiungiProdotto(new Libro("77898515634","Harry Potter e il calice di fuoco",
                LocalDate.of(2000,7,8),655,"J.K.Rowling","Fantasy"));

        archivio.aggiungiProdotto(new Libro("77898576351","Harry potter e l'ordine della fenice",
                LocalDate.of(2003,6,21),853,"J.K.Rowling","Fantasy"));

        archivio.aggiungiProdotto(new Libro("77898547625","Harry potter e il principe mezzosangue",
                LocalDate.of(2005,7,16),576,"J.K.Rowling","Fantasy"));

        archivio.aggiungiProdotto(new Libro("77898547777","Harry potter e i doni della morte ",
                LocalDate.of(2007,7,21),656,"J.K.Rowling","Fantasy"));

        archivio.aggiungiProdotto(new Libro("77898547512","Harry potter e la maledizione dell'erede",
                LocalDate.of(2016,7,30),353,"J.K.Rowling","Fantasy"));




        archivio.aggiungiProdotto(new Rivista("12657412137","Motociclismo",
                LocalDate.of(2024,4,26),35,Periodicita.SETTIMANALE));
        archivio.aggiungiProdotto(new Rivista("32657478367","Focus",
                LocalDate.of(2024,3,15),30,Periodicita.MENSILE));
        archivio.aggiungiProdotto(new Rivista("33787412687","Panorama",
                LocalDate.of(2024,1,26),60,Periodicita.SETTIMANALE));

        System.out.println("----------------------------------");
        System.out.println("Ricerca per ISBN: "+archivio.cercaPerISBN("7896541213"));
        List<Catalogo> prodottiAnno2024 = archivio.ricercaPerAnnoPubblicazione(LocalDate.of(2000, 1,
                1));

        System.out.println("----------------------------------");
        System.out.println("Catalogo 2024:");
        prodottiAnno2024.forEach(System.out::println);


        System.out.println("----------------------------------");
        List<Catalogo> ricercaAutore=archivio.cercaPerAutore("J.K.Rowling");
        System.out.println("Libri di J.K.Rowling");
        ricercaAutore.forEach(System.out::println);
        System.out.println("----------------------------------");

        try {
            archivio.salvaSulDisco("archivioDati.txt");
            System.out.println("File salvato con successo ");
        }catch (IOException e){
            System.out.println("Errore nel salvataggio del file");
        }
        System.out.println("----------------------------------");
        try {
            List<Catalogo> archivioCaricato=archivio.caricamentoSulDisco("archivioDati.txt");
            System.out.println("Archivio caricato da disco:");
            archivioCaricato.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Errore nel caricamento del file");
        }
   }
}
