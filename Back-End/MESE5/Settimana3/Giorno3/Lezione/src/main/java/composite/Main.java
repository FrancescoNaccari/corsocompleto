package composite;

public class Main {
    public static void main(String[] args) {
        Libro l1 = new Libro("l1",5,4000);
        Libro l2 = new Libro("l2",6,200);
        Libro l3 = new Libro("l3",7,150);
        Libro l4 = new Libro("l4",8,2000);
        Libro l5 = new Libro("l5",9,100);
        Libro l6 = new Libro("l6",10,200);
        Libro l7 = new Libro("l7",11,100);
        Libro l8 = new Libro("l8",12,200);
        Libro l9 = new Libro("l9",13,250);
        Libro l10 = new Libro("l10",15,200);

        Scatolo scatolo1 = new Scatolo("scatolo1");
        Scatolo scatolo2 = new Scatolo( "scatolo2");
        Scatolo scatolo3 = new Scatolo( "scatolo3");
        Scatolo scatolo4 = new Scatolo( "scatolo4");

        scatolo4.addProdotto(l1);
        scatolo4.addProdotto(l2);
        scatolo4.addProdotto(l3);

        scatolo3.addProdotto(l4);
        scatolo3.addProdotto(l5);
        scatolo3.addProdotto(l6);

        scatolo2.addProdotto(l7);
        scatolo2.addProdotto(l8);
        scatolo2.addProdotto(l9);

        scatolo1.addProdotto(l10);
        scatolo1.addProdotto(scatolo2);
        scatolo1.addProdotto(scatolo3);
        scatolo1.addProdotto(scatolo4);

        System.out.println(scatolo1.getPrezzo());
        System.out.println(scatolo1.getPeso());

    }
}
