package it.nextdevs.esercizio;

import it.nextdevs.esercizio.bean.Drink;
import it.nextdevs.esercizio.bean.Pizza;
import it.nextdevs.esercizio.bean.Topping;
import it.nextdevs.esercizio.service.CaloriePrezzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CaloriePrezzoService caloriePrezzoService;


    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(EsercizioApplication.class);// accesso al contesto

//
//        Drink drink = ctx.getBean("Wine", Drink.class);
//        caloriePrezzoService.inserisciCaloriePrezzo(drink);
//
//        Drink drink2 = ctx.getBean("Water", Drink.class);
//        caloriePrezzoService.inserisciCaloriePrezzo(drink2);
//
//
//        Topping topping = ctx.getBean("tomato", Topping.class);
//        caloriePrezzoService.inserisciCaloriePrezzo(topping);
//
//        Topping topping2 = ctx.getBean("salami", Topping.class);
//        caloriePrezzoService.inserisciCaloriePrezzo(topping2);
//
//        Topping topping3 = ctx.getBean("pineapple", Topping.class);
//        caloriePrezzoService.inserisciCaloriePrezzo(topping3);
//
//        Topping topping4 = ctx.getBean("cheese", Topping.class);
//        caloriePrezzoService.inserisciCaloriePrezzo(topping4);
//
//        Topping topping5 = ctx.getBean("onion", Topping.class);
//        caloriePrezzoService.inserisciCaloriePrezzo(topping5);
//
//        Topping topping6 = ctx.getBean("ham", Topping.class);
//        caloriePrezzoService.inserisciCaloriePrezzo(topping6);
//
//        Pizza pizza = ctx.getBean("Margherita", Pizza.class);
//        caloriePrezzoService.inserisciCaloriePrezzo(pizza);
//
//        Pizza pizza2 = ctx.getBean("Salami_pizza", Pizza.class);
//        caloriePrezzoService.inserisciCaloriePrezzo(pizza2);
//
//        Pizza pizza3 = ctx.getBean("Hawaian_pizza", Pizza.class);
//        caloriePrezzoService.inserisciCaloriePrezzo(pizza3);

        System.out.println(caloriePrezzoService.getPizzaByPriceLessThan(10.0));
        System.out.println(caloriePrezzoService.countPizze());

    }
}
