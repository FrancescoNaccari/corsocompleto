package nextdevs.lezioneSpring.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString(callSuper = true)
public class Computer extends Dispositivo {
    private int monitor;
    private int ram;
    private String cpu;
}
