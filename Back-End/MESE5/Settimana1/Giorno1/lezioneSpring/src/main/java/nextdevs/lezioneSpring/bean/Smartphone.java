package nextdevs.lezioneSpring.bean;


import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Smartphone extends Dispositivo  {
    private int schermo;

}
