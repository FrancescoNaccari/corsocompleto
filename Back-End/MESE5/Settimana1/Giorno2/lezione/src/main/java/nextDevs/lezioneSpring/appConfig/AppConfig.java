package nextDevs.lezioneSpring.appConfig;


import nextDevs.lezioneSpring.bean.Aula;
import nextDevs.lezioneSpring.bean.Computer;
import nextDevs.lezioneSpring.bean.Smartphone;
import nextDevs.lezioneSpring.bean.Studente;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean("Mario")
    @Primary
   // @Scope("prototype")
    public Studente getStudente(@Value("${studente1.nome}") String nome,@Value("${studente1.cognome}")  String cognome) {
        Studente studente = new Studente();
        studente.setNome(nome);
        studente.setCognome(cognome);
        studente.setIndirizzo("Via Roma");
        studente.setDispositivi(List.of(getComputer(), getSmartphone()));

        return studente;
    }

    @Bean
    public Studente getStudente2() {
        Studente studente = new Studente();
        studente.setNome("Luigi");
        studente.setCognome("Bianchi");
        studente.setIndirizzo("Via Catania");
        return studente;
    }

    @Bean("computer")
    public Computer getComputer() {
        Computer computer = new Computer();
        computer.setNome("MacBook Pro");
        computer.setMarca("Apple");
        computer.setCpu("Intel");
        computer.setRam(16);
        computer.setMonitor(32);
        return computer;
    }

    @Bean("smartphone")
    public Smartphone getSmartphone() {
        Smartphone smartphone = new Smartphone();
        smartphone.setNome("Samsung Galaxy S10");
        smartphone.setMarca("Samsung");
        smartphone.setSchermo(6);
        return smartphone;
    }

//    @Bean
//    public Aula getAula() {
//        Aula aula = new Aula();
//        aula.setNome("A1");
//        aula.setStudenti(List.of(getStudente(), getStudente2()));
//        return aula;
//    }

}
