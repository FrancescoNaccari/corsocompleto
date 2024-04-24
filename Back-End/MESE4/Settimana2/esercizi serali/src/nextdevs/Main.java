package nextdevs;

public class Main {
    public static void main(String[] args) {
        Ingrediente pomodoro=new Ingrediente("Pomodoro",50);
        Ingrediente mozzarella=new Ingrediente("Mozzarella",100);
        Ingrediente basilico=new Ingrediente("Basilico",10);

        Pizza margherita=new Pizza("Margherita",5.0);
        margherita.aggiungiIngrediente(pomodoro);
        margherita.aggiungiIngrediente(mozzarella);
        margherita.aggiungiIngrediente(basilico);

        int kcalPizza= margherita.kilocalorie();

        System.out.println("Pizza"+margherita.getNome());
        System.out.println("Prezzo"+margherita.getPrezzo()+"euro");
        System.out.println("Kilocalorie"+kcalPizza+"kcal");

    }
}
