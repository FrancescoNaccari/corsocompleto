package nextdevs.lezioneSpring.appConfig;

import nextdevs.lezioneSpring.bean.Aula;
import nextdevs.lezioneSpring.bean.Computer;
import nextdevs.lezioneSpring.bean.Smartphone;
import nextdevs.lezioneSpring.bean.Studente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    @Primary
   // @Scope("prototype")
    public Studente getStudente() {
        Studente studente = new Studente();
        studente.setNome("Mario");
        studente.setCognome("Rossi");
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

    @Bean
    public Computer getComputer() {
        Computer computer = new Computer();
        computer.setNome("MacBook Pro");
        computer.setMarca("Apple");
        computer.setCpu("Intel");
        computer.setRam(16);
        computer.setMonitor(32);
        return computer;
    }

    @Bean
    public Smartphone getSmartphone() {
        Smartphone smartphone = new Smartphone();
        smartphone.setNome("Samsung Galaxy S10");
        smartphone.setMarca("Samsung");
        smartphone.setSchermo(6);
        return smartphone;
    }

    @Bean
    public Aula getAula() {
        Aula aula = new Aula();
        aula.setNome("A1");
        aula.setStudenti(List.of(getStudente(), getStudente2()));
        return aula;
    }

}
