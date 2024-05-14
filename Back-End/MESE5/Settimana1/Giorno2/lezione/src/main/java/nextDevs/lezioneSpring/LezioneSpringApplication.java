package nextDevs.lezioneSpring;


import nextDevs.lezioneSpring.appConfig.AppConfig;
import nextDevs.lezioneSpring.bean.Aula;
import nextDevs.lezioneSpring.bean.Studente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class LezioneSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(LezioneSpringApplication.class, args);

		//accediamo al contesto di spring
	ApplicationContext ctx=new AnnotationConfigApplicationContext(LezioneSpringApplication.class);
	Aula aula=ctx.getBean(Aula.class);

	System.out.println(aula);




	}



}
