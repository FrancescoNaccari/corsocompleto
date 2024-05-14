package nextDevs.lezioneSpring.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component ("aula1")//permette di far creare oggetti di tipo aula direttamente a spring
@PropertySource("application.properties")
public class Aula {
    @Value("${aula.nome}")
    private String nome;
    // inetta la lista di studenti prendendoli direttamente dal contesto
    @Autowired
    private List<Studente> studenti;

    //inietto gli studenti che sono nel contesto, nella lista del costruttore
//    @Autowired
//    public Aula(List<Studente> studenti) {
//        this.studenti = studenti;
//
//    }

//    @Autowired // crea prima un oggetto aula e poi setta nell'aula una lista di studenti presi nel cotesto
//    public void setStudenti(List<Studente> studenti) {
//        this.studenti = studenti;
//    }
}
