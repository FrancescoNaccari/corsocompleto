package NextDevs.esercizio.bean;

import NextDevs.esercizio.appConfig.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OrdineRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(OrdineRunner.class);

    private final Menu menu;
    private final AppConfig appConfig;

    public OrdineRunner(Menu menu, AppConfig appConfig) {
        this.menu = menu;
        this.appConfig = appConfig;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Inizializzazione del menu...");
        menu.stampaMenu();

        // Creazione di un ordine
        Ordine ordine = appConfig.creaOrdine(menu);
        logger.info("Ordine creato:");
        logger.info("Numero ordine: {}", ordine.getNumeroOrdine());
        logger.info("Stato ordine: {}", ordine.getStatoOrdine());
        logger.info("Numero coperti: {}", ordine.getNumCoperti());
        logger.info("Ora acquisizione: {}", ordine.getOraAcquisizione());
        logger.info("Importo totale: {}", ordine.getImportoTotale());

        // Stampa dettagli ordine
        logger.info("Dettagli ordine:");
        ordine.getOrderedProducts().forEach(item -> logger.info("Prodotto: {}, Prezzo: {}", item, item.getPrezzo()));
    }
}
