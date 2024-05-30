package chainOfResponsability;

public class Main {
    public static void main(String[] args) {
        ContoBancario contoBancario = new ContoBancario(123,1000,479,479);

        Erogatore200 erogatore200=new Erogatore200();
        Erogatore100 erogatore100=new Erogatore100();
        Erogatore50 erogatore50=new Erogatore50();
        Erogatore20 erogatore20=new Erogatore20();
        Erogatore10 erogatore10=new Erogatore10();
        Erogatore5 erogatore5=new Erogatore5();
        Erogatore2 erogatore2=new Erogatore2();
        Erogatore1 erogatore1=new Erogatore1();

        erogatore200.setErogatoreSuccessivo(erogatore100);
        erogatore100.setErogatoreSuccessivo(erogatore50);
        erogatore50.setErogatoreSuccessivo(erogatore20);
        erogatore20.setErogatoreSuccessivo(erogatore10);
        erogatore10.setErogatoreSuccessivo(erogatore5);
        erogatore5.setErogatoreSuccessivo(erogatore2);
        erogatore2.setErogatoreSuccessivo(erogatore1);

       erogatore200.eroga(contoBancario);




    }
}
