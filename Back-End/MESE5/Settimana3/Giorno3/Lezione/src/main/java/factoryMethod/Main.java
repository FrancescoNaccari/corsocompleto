package factoryMethod;

public class Main {
    public static void main(String[] args) {
        Animale animale1= Factory.getAnimale(Tipo.CANE);
         Animale animale2= Factory.getAnimale(Tipo.COCCODRILLO);
         Animale animale3= Factory.getAnimale(Tipo.GATTO);

         animale1.verso();
         animale2.verso();
         animale3.verso();


    }
}
