package NextDevs.esercizio.bean;

import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("application.properties")
public class Tavolo {
    private int numeroTavolo;
    private int numeroCopertiMax;
    private StatoTavolo statoTavolo;
    @Value("${costo.coperto}")
    private Double costoCoperto;
}
