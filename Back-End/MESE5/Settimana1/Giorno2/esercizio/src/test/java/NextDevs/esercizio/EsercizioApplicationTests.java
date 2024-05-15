package NextDevs.esercizio;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class EsercizioApplicationTests {
	static ApplicationContext ctx;
	@BeforeAll
	public static void accediAlContesto(){
		ctx=new AnnotationConfigApplicationContext(EsercizioApplication.class);
		System.out.println("Accesso al contesto avvenuto");
	}
	@Test
	void contextLoads() {
	}
	@AfterAll
	public static void chiudiContesto(){
		ctx=null;
		System.out.println("Contesto chiuso");
	}
}
