package nextDevs.progettoSettimanale.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Laptop extends Dispositivo{

    private int ram;
    private String cpu;
}
