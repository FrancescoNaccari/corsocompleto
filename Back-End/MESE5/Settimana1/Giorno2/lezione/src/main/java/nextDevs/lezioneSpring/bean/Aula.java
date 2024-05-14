package nextDevs.lezioneSpring.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Aula {
    private String nome;
    private List<Studente> studenti;
}
