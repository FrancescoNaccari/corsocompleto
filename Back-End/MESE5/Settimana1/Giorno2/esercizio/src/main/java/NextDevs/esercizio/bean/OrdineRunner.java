package NextDevs.esercizio.bean;

import NextDevs.esercizio.EsercizioApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class OrdineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        // Inizializzazione del contesto dell'applicazione
        ApplicationContext ctx = new AnnotationConfigApplicationContext(EsercizioApplication.class);

        // Ottenimento dei bean dopo l'inizializzazione del contesto
        Menu menu = ctx.getBean(Menu.class);
        Ordine ordine = ctx.getBean(Ordine.class);

        // Utilizzo dei bean ottenuti per stampare le informazioni
        System.out.println("Inizializzazione del menu...");
        menu.stampaMenu();

        System.out.println("Ordine creato:");
        System.out.println("Numero ordine: " + ordine.getNumeroOrdine());
        System.out.println("Stato ordine: " + ordine.getStatoOrdine());
        System.out.println("Numero coperti: " + ordine.getNumCoperti());
        System.out.println("Ora acquisizione: " + ordine.getOraAcquisizione());
        System.out.println("Importo totale: " + ordine.getImportoTotale());

        System.out.println("Dettagli ordine:");
        ordine.getOrderedProducts().forEach(item -> System.out.println("Prodotto: " + item + ", Prezzo: " + item.getPrezzo()));
    }
}
