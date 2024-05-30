package factoryMethod;

public class Factory {
    private static Animale animale;

    public static Animale getAnimale(Tipo tipo) {
        switch (tipo) {
            case COCCODRILLO:
                animale = new Coccodrillo();
                break;
            case GATTO:
                animale = new Gatto();
                break;
            case CANE: animale=new Cane();
        }
        return animale;

    }
}
