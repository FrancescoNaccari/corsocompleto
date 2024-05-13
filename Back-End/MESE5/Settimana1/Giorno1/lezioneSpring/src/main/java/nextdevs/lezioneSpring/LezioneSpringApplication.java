package nextdevs.lezioneSpring;

import nextdevs.lezioneSpring.appConfig.AppConfig;
import nextdevs.lezioneSpring.bean.Aula;
import nextdevs.lezioneSpring.bean.Studente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class LezioneSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LezioneSpringApplication.class, args);

		//accediamo al contesto di spring
	ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
	//recuperiamo dal contesto il bean creato da spring
	Studente studente= ctx.getBean(Studente.class);
	Studente studente2= ctx.getBean(Studente.class);

	studente.setCognome("Verdi");

	System.out.println(studente==studente2);
	System.out.println(studente);
	System.out.println(studente2);


		Aula aula=ctx.getBean(Aula.class);
		System.out.println(aula);

	}



}
