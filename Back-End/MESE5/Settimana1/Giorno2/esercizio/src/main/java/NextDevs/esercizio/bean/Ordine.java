package NextDevs.esercizio.bean;

import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class Ordine {

    private int numeroOrdine;
    private StatoOrdine statoOrdine;
    private Tavolo tavolo;
    private List<CaloriePrezzo>orderedProducts;
    private int numCoperti;
    private LocalTime oraAcquisizione;
    private double importoTotale;


    public void calcolaImportoTotale(double costoCoperto) {
        double costoProdotti = orderedProducts.stream().mapToDouble(CaloriePrezzo::getPrezzo).sum();
        importoTotale = costoProdotti + (numCoperti * costoCoperto);
    }
}
