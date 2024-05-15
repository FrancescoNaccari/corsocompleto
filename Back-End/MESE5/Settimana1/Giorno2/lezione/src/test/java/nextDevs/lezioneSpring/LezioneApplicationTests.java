package nextDevs.lezioneSpring;

import nextDevs.lezioneSpring.bean.Aula;
import nextDevs.lezioneSpring.bean.Studente;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
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

	@ParameterizedTest // test parametrizzato, che viene ripetuto tante volte quante sono le stringhe nell'array
	@ValueSource(strings = {"M","L"})
	public void verificaNumeroStudentiConNomeCheIniziaCon(String inizio){
		Aula aula=ctx.getBean(Aula.class);
		aula.getStudenti().stream().filter(s->s.getNome().startsWith(inizio)).forEach(System.out::println);
		long numero= aula.getStudenti().stream().filter(s->s.getNome().startsWith(inizio)).count();
		Assertions.assertEquals(1,numero);
	}
	@ParameterizedTest
	@CsvSource({"M,1","L,1","A,0"})
	public void verificaNumeroStudentiConNomeCheIniziaCon(String inizio,long conteggio){
		Aula aula=ctx.getBean(Aula.class);
		aula.getStudenti().stream().filter(s->s.getNome().startsWith(inizio)).forEach(System.out::println);
		long numero= aula.getStudenti().stream().filter(s->s.getNome().startsWith(inizio)).count();
		Assertions.assertEquals(conteggio,numero);
	}

	@AfterAll
	public static void chiudiContesto(){
		ctx=null;
		System.out.println("Contesto chiuso");
	}

}
