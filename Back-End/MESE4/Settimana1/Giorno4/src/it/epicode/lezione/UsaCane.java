package it.epicode.lezione;

public class UsaCane {
    public static void main(String[] args) {
        Cane cane=new Cane("Dobermann","Pavlo",4);


        System.out.println(cane.getNome());
        System.out.println(cane.getRazza());
        System.out.println(cane.getZampe());

        System.out.println(cane.visualizzaDati());
        cane.verso();
        System.out.println("-----------------------------");


        Animale animale=new Cane("pastore", "pavlo", 4);
        System.out.println(animale.getZampe());
        System.out.println( animale.visualizzaDati());
        System.out.println("-----------------------------");
        Animale[] animali=new Animale[3];

        animali[0]=animale;
        animali[1]=new Cane("tedesto","carlo",3);
        animali[2]=new Cane("tedesto","pino",4);

        for (int i=0; i<animali.length;i++){
            System.out.println(animali[i].getNome());
            animali[i].verso();
        }
    }
}
