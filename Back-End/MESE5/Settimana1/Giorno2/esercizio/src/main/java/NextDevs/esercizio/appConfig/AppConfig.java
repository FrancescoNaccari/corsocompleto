package NextDevs.esercizio.appConfig;

import NextDevs.esercizio.bean.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {


    @Bean
    public Topping pomodoro() {
     Topping pomodoro = new Topping();
     pomodoro.setNome("Pomodoro");
     pomodoro.setCalorie(50);
     pomodoro.setPrezzo(2.00);
        return pomodoro;
    }
    @Bean
    public Topping mozzarella() {
        Topping mozzarella = new Topping();
        mozzarella.setNome("Mozzarella");
        mozzarella.setCalorie(50);
        mozzarella.setPrezzo(2.00);
        return mozzarella;
    }

    @Bean
    public Topping salame() {
        Topping salame = new Topping();
        salame.setNome("Salame");
        salame.setCalorie(50);
        salame.setPrezzo(2.00);
        return salame;
    }
    @Bean
    public Topping ananas() {
        Topping ananas = new Topping();
        ananas.setNome("Ananas");
        ananas.setCalorie(50);
        ananas.setPrezzo(2.00);
        return ananas;
    }

    @Bean
    public Topping onions() {
        Topping onions = new Topping();
        onions.setNome("Onions");
        onions.setCalorie(50);
        onions.setPrezzo(2.00);
        return onions;
    }
//@Bean
//@Scope("prototype")
    public Pizza base() {
        Pizza base = new Pizza();
        ArrayList<Topping> toppingList = new ArrayList<>();
        toppingList.add(mozzarella());
        base.setToppingList(toppingList);
        return base;
    }


    @Bean
    public Pizza margherita() {
        Pizza margherita = base();
        margherita.setNome("Margherita");
       margherita.getToppingList().add(pomodoro());
        margherita.setCalorie(1010);
        margherita.setPrezzo(10.00);
        return margherita;
    }
    @Bean
    public Pizza diavola() {
        Pizza pizzaDiavola = base();
        pizzaDiavola.setNome("Diavola");
        pizzaDiavola.getToppingList().add(pomodoro());
        pizzaDiavola.getToppingList().add(salame());
        pizzaDiavola.setCalorie(1010);
        pizzaDiavola.setPrezzo(10.00);
        return pizzaDiavola;
    }

    @Bean
    public Pizza hawaii() {
        Pizza hawaii = base();
        hawaii.setNome("Hawaii");
        hawaii.getToppingList().add(pomodoro());
        hawaii.getToppingList().add(salame());
        hawaii.getToppingList().add(ananas());
        hawaii.setCalorie(1010);
        hawaii.setPrezzo(10.00);
        return hawaii;
    }



    @Bean
    public Drink coca_cola() {
        Drink coca_cola = new Drink();
        coca_cola.setNome("Coca Cola");
        coca_cola.setPrezzo(2.00);
        coca_cola.setCalorie(100);
        coca_cola.setGradoAlcohol(0);
        coca_cola.setMl(0.33);
        return coca_cola;

    }

    @Bean
    public Drink limonata() {
        Drink limonata = new Drink();
        limonata.setNome("Limonata");
        limonata.setPrezzo(2.00);
        limonata.setCalorie(100);
        limonata.setGradoAlcohol(0);
        limonata.setMl(0.40);
        return limonata;

    }

    @Bean
    public Drink moretti() {
        Drink moretti = new Drink();
        moretti.setNome("Moretti");
        moretti.setPrezzo(2.00);
        moretti.setCalorie(100);
        moretti.setGradoAlcohol(5);
        moretti.setMl(0.5);
        return moretti;
    }




    @Bean
    public Menu getMenu() {
        Menu menu = new Menu();

        ArrayList<Drink> bevande = new ArrayList<>();
        bevande.add(coca_cola());
        bevande.add(limonata());
        bevande.add(moretti());

        ArrayList<Topping> toppings = new ArrayList<>();
        toppings.add(pomodoro());
        toppings.add(mozzarella());
        toppings.add(salame());
        toppings.add(ananas());
        toppings.add(onions());


        ArrayList<Pizza> pizze = new ArrayList<>();
        pizze.add(margherita());
        pizze.add(diavola());
        pizze.add(hawaii());



        menu.setIngredienti(toppings);
        menu.setPizze(pizze);
        menu.setBevande(bevande);

        return menu;


    }


    @Bean
    public Tavolo creaTavolo() {
        Tavolo tavolo = new Tavolo();
        tavolo.setNumeroTavolo(1);
        tavolo.setNumeroCopertiMax(6);
        tavolo.setStatoTavolo(StatoTavolo.LIBERO);
        tavolo.setCostoCoperto(tavolo.getCostoCoperto());
        return tavolo;
    }


    @Bean
    public Ordine creaOrdine(Menu menu) {
        Ordine ordine = new Ordine();
        ordine.setNumeroOrdine(1);
        ordine.setStatoOrdine(StatoOrdine.IN_CORSO);
        ordine.setTavolo(creaTavolo());
        ordine.setOrderedProducts(new ArrayList<>(menu.getPizze())); // Esempio di aggiunta di pizze all'ordine
        ordine.setNumCoperti(4);
        ordine.setOraAcquisizione(LocalTime.now());
        ordine.calcolaImportoTotale(creaTavolo().getCostoCoperto());
        return ordine;
    }



}
