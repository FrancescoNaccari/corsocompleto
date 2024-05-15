package NextDevs.esercizio;

import NextDevs.esercizio.appConfig.AppConfig;
import NextDevs.esercizio.bean.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class EsercizioApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsercizioApplication.class, args);

//
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
////		System.out.println("-------------------------------");
//		System.out.println("TOPPING: ");
//		Topping pomodoro = ctx.getBean("pomodoro",Topping.class);
//		Topping salame = ctx.getBean("salame",Topping.class);
//		Topping ananas = ctx.getBean("ananas",Topping.class);
//		Topping onions = ctx.getBean("onions",Topping.class);
//
//		System.out.println(pomodoro);
//		System.out.println(salame);
//
//		System.out.println("-------------------------------");
//		System.out.println("PIZZE: ");
//		Pizza margherita = ctx.getBean("margherita",Pizza.class);
//		Pizza diavola = ctx.getBean("diavola",Pizza.class);
//		Pizza hawaii = ctx.getBean("hawaii",Pizza.class);
//		System.out.println(margherita);
//		System.out.println(diavola);
//		System.out.println(hawaii);
//
//
//		System.out.println("-------------------------------");
//		System.out.println("DRINK: ");
//
//		Drink drink1 = ctx.getBean("coca_cola", Drink.class);
//		Drink drink2 = ctx.getBean("limonata", Drink.class);
//		Drink drink3 = ctx.getBean("moretti", Drink.class);
//
//		System.out.println(drink1);
//		System.out.println(drink2);
//		System.out.println(drink3);
//
//		System.out.println("-------------------------------");
//		System.out.println("MENU: ");
//		Menu menu = ctx.getBean("menu",Menu.class);
//		System.out.println(menu);
//

//		Menu menu = ctx.getBean(Menu.class);
//		menu.stampaMenu();
////
//		AppConfig appConfig;
//
//		Menu menu1 = appConfig.getMenu();
//		Tavolo tavolo = appConfig.creaTavolo();
//
//		Ordine ordine = appConfig.creaOrdine(menu1);
//		LOGGER.info("Ordine creato: {}", ordine);
//
//		// Simuliamo il cambio di stato dell'ordine
//		ordine.setStatoOrdine(StatoOrdine.PRONTO);
//		LOGGER.info("Stato dell'ordine cambiato a PRONTO: {}", ordine);
//
//		// Simuliamo il cambio di stato del tavolo
//		tavolo.setStatoTavolo(NextDevs.esercizio.bean.StatoTavolo.OCCUPATO);
//		LOGGER.info("Stato del tavolo cambiato a OCCUPATO: {}", tavolo);


	}


}
