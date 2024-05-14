package nextDevs.lezioneSpring.bean;

import nextDevs.lezioneSpring.LezioneSpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(LezioneSpringApplication.class);

        Aula aula=ctx.getBean(Aula.class);
        System.out.println(aula);

        Dispositivo dispositivo= ctx.getBean("smartphone",Dispositivo.class);
        System.out.println(dispositivo);

        Scuola scuola=ctx.getBean(Scuola.class);
        System.out.println(scuola);



    }
}
