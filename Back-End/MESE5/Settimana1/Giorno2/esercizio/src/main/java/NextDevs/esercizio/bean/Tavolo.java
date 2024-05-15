package NextDevs.esercizio.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data

public class Tavolo {
    private int numeroTavolo;
    private int numeroCopertiMax;
    private StatoTavolo statoTavolo;
    @Value("${costo.coperto}")
    private double costoCoperto;
}
