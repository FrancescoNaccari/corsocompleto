package NextDevs.esercizio;

import NextDevs.esercizio.bean.Pizza;
import NextDevs.esercizio.bean.Tavolo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class EsercizioApplicationTests {
	private static ApplicationContext ctx;
	@BeforeAll
	public static void accediAlContesto(){
		ctx=new AnnotationConfigApplicationContext(EsercizioApplication.class);
		System.out.println("Accesso al contesto avvenuto");
	}
	@Test
	void verificaNomePizza() {
		Pizza pizza=ctx.getBean("Margherita",Pizza.class);
		Assertions.assertEquals("Margherita",pizza.getNome());
		System.out.println("verificata pizza Margherita");
	}

	@Test
	void verificaCostoCopertoTavolo1(){
		Tavolo tavolo1=ctx.getBean("tavolo", Tavolo.class);
		Assertions.assertEquals(2.2,tavolo1.getCostoCoperto());
	}


//	@ParameterizedTest
//	@CsvSource({"tavolo,2.2","tavolo2,2.5"})
//	public void verificaCostoCopertoPerTuttiTavoli(String tavolo, double coperto){
//	Tavolo t=ctx.getBean(tavolo,Tavolo.class);
//	Assertions.assertEquals(coperto,t.getCostoCoperto());
//	}


	@AfterAll
	public static void chiudiContesto(){
		ctx=null;
		System.out.println("Contesto chiuso");
	}
}
