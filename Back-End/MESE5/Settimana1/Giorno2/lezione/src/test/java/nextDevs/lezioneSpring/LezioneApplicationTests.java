package nextDevs.lezioneSpring;

import nextDevs.lezioneSpring.bean.Aula;
import nextDevs.lezioneSpring.bean.Studente;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class LezioneApplicationTests {

static	ApplicationContext ctx;
	@BeforeAll
	public static void accediAlContesto(){
		ctx=new AnnotationConfigApplicationContext(LezioneSpringApplication.class);
		System.out.println("Accesso al contesto avvenuto");
	}


	@Test
	void verificaNomePrimoStudente() {
		Studente studente1=ctx.getBean("Mario",Studente.class);
		Assertions.assertEquals("Mario",studente1.getNome());
	}

	@Test
	public void verificaAulaNotNull(){
		Aula aula=ctx.getBean(Aula.class);
		Assertions.assertNotNull(aula);
	}
@Test
	public void verificaNumeroStudentiInAula() {
		Aula aula=ctx.getBean(Aula.class);
		Assertions.assertEquals(2,aula.getStudenti().size());
	}

	@AfterAll
	public static void chiudiContesto(){
		ctx=null;
		System.out.println("Contesto chiuso");
	}

}
