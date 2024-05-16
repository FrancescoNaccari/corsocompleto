package netxdevs.lezione4;

import netxdevs.lezione4.service.DispositivoService;
import netxdevs.lezione4.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private StudenteService studenteService;
    @Autowired
    private DispositivoService dispositivoService;


    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(Lezione4Application.class);

//        Studente studente1=ctx.getBean("Mario",Studente.class);
//        studenteService.inserisciStudente(studente1);
//
//        Studente studente2=ctx.getBean("Luigi",Studente.class);
//        studenteService.inserisciStudente(studente2);
//
//        Computer computer1=ctx.getBean(Computer.class);
//        computer1.setStudente(studente1);
//        dispositivoService.inserisciDispositivo(computer1);
//
//        Smartphone smartphone1=ctx.getBean(Smartphone.class);
//        smartphone1.setStudente(studente2);
//        dispositivoService.inserisciDispositivo(smartphone1);

        System.out.println(studenteService.getStudentiByNome("Mario"));
        System.out.println(studenteService.getStudentiByPartialNome("%u%"));
        System.out.println(dispositivoService.getComputerByRamLessThan(24));
        System.out.println(dispositivoService.getDispositiviOrderByNomeDesc());
    }
}
