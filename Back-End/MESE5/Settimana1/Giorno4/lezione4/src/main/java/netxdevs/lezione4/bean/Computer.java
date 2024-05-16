package netxdevs.lezione4.bean;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.ToString;


@Data
@Entity
@ToString(callSuper = true)
public class Computer extends Dispositivo {
    private int monitor;
    private int ram;
    private String cpu;
}
