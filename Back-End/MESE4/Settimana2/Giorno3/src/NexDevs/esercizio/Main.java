package NexDevs.esercizio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> prodotti =new ArrayList<>();
        Product prodotto1 =new Product(1L,"epicode","Books",70.45);
        Product prodotto2 =new Product(2L,"harry potter","Books",322.50);
        Product prodotto3 =new Product(3L,"fuga ","Books",122.40);

        Product prodotto4=new Product(4L,"scarpette","baby",50);
        Product prodotto5=new Product(5L,"pannolini ","baby",39.96);
        Product prodotto6=new Product(6L,"maglietta","baby",15.5);

        Product prodotto7=new Product(7L,"pantaloni","boys",122.99);
        Product prodotto8=new Product(8L,"cinta","boys",62.9);
        Product prodotto9=new Product(9L,"maglione","boys",82.5);




        prodotti.add(prodotto1);
        prodotti.add(prodotto2);
        prodotti.add(prodotto3);
        prodotti.add(prodotto4);
        prodotti.add(prodotto5);
        prodotti.add(prodotto6);
        prodotti.add(prodotto7);
        prodotti.add(prodotto8);
        prodotti.add(prodotto9);


        //Esercizio1
        System.out.println("Esercizio1");
        List<Product> libriCostosi = prodotti.stream()
                .filter(product -> product.getCategory().equals("Books"))
                .filter(product -> product.getPrice() > 100)
                .toList();
        libriCostosi.forEach(prodotto -> {
            System.out.println("ID: "+prodotto.getId());
            System.out.println("Nome: "+prodotto.getName());
            System.out.println("Categoria: "+prodotto.getCategory());
            System.out.println("Prezzo: "+prodotto.getPrice());
            System.out.println("-----------------------");


        });  libriCostosi.forEach(System.out::println);



        //Esercizio2
        System.out.println("Esercizio2");
        System.out.println("-----------------------");
        Customer utente1=new Customer(1,"Fabio Brogi",1);
        Customer utente2=new Customer(1,"Francesco Naccari",2);
        Customer utente3=new Customer(1,"Antonio Copetti",1);
        Customer utente4=new Customer(1,"Enrico Cirotto",1);

        Order order1=new Order(1,"ordinato",LocalDate.now(), LocalDate.now().plusDays(3),new ArrayList<Product>(),utente1);
        order1.addProduct(prodotto2);
        order1.addProduct(prodotto5);
        order1.addProduct(prodotto8);
        order1.addProduct(prodotto7);
        Order order2=new Order(2,"ordinato",LocalDate.now(), LocalDate.now().plusDays(3),new ArrayList<Product>(),utente2);
        order2.addProduct(prodotto9);
        order2.addProduct(prodotto1);
        order2.addProduct(prodotto4);
        order2.addProduct(prodotto3);
        Order order3=new Order(3,"ordinato",LocalDate.now(), LocalDate.now().plusDays(3),new ArrayList<Product>(),utente3);
        order3.addProduct(prodotto7);
        order3.addProduct(prodotto6);
        order3.addProduct(prodotto8);
        order3.addProduct(prodotto3);
        Order order4=new Order(4,"ordinato",LocalDate.now(), LocalDate.now().plusDays(3),new ArrayList<Product>(),utente4);
        order4.addProduct(prodotto3);
        order4.addProduct(prodotto5);
        order4.addProduct(prodotto1);
        order4.addProduct(prodotto2);

        List<Order> ordini=Order.getOrders();
        List<Order> ordiniBaby=ordini.stream().filter(order -> {
                    List<Product>prodottiBaby=order.getProducts().stream().filter(product -> product.getCategory()
                            .equals("baby")).toList();
                    return !prodottiBaby.isEmpty();
                }).toList();
        ordiniBaby.forEach(order -> {
            System.out.println("ID:"+ order.getId());
            System.out.println("Status:"+ order.getStatus());
            System.out.println("Data ordine:"+ order.getOrderData());
            System.out.println("Data consegna:"+ order.getDeliveryDate());
            Integer articoli=order.getProducts().size();
            System.out.println("Articoli"+ articoli);
            System.out.println("Cliente ID:"+ order.getCustomer().getId());
            System.out.println("Nome Cliente:"+ order.getCustomer().getName());
            System.out.println("Tier:"+ order.getCustomer().getTier());

            System.out.println("-----------------------");

        });
        ordiniBaby.forEach(System.out::println);

        //Esercizio3
        System.out.println("Esercizio3");
        System.out.println("-----------------------");

        List<Product> prodottiBoys = prodotti.stream()
                .filter(product -> product.getCategory().equals("boys"))
                .peek(product -> product.setPrice(product.getPrice() * 0.9))
                .toList();

        System.out.println("Prodotti boys con sconto:");
        prodottiBoys.forEach(prodotto -> {
            System.out.println("ID: " + prodotto.getId());
            System.out.println("Nome: " + prodotto.getName());
            System.out.println("Categoria: " + prodotto.getCategory());
            System.out.println("Prezzo scontato: " + (Math.round( prodotto.getPrice()*100.0)/100.0) );

            System.out.println("-----------------------");
        });
        prodottiBoys.forEach(System.out::println);
//Esercizio4
        System.out.println("Esercizio4");
        System.out.println("-----------------------");


        List<Order>ordiniTier2=ordini.stream()
                .filter(order-> order.getCustomer().getTier()==2)
                .filter(order ->{
                    LocalDate inizio =LocalDate.of(2024,2,1);
                    LocalDate fine=LocalDate.of(2024,5,1);
                    return  order.getOrderData().isAfter(inizio)&& order.getOrderData().isBefore(fine);

                } ).toList();
        List<Product>prodottiTier2=new ArrayList<>();
        ordiniTier2.forEach(order->{
            prodottiTier2.addAll(order.getProducts());
        });
//        prodottiTier2.forEach(prodotto -> {
//            System.out.println("ID: "+prodotto.getId());
//            System.out.println("Nome: "+prodotto.getName());
//            System.out.println("Categoria: "+prodotto.getCategory());
//            System.out.println("Prezzo: "+prodotto.getPrice());
//    });
        prodottiTier2.forEach(System.out::println);
}}
