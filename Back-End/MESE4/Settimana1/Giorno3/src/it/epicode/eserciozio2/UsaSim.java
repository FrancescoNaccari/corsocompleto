package it.epicode.eserciozio2;

public class UsaSim {
    public static void main(String[] args) {

        Sim sim=new Sim(1313213321);
           sim.setCredito(10);

           Chiamata[] chiamata= new Chiamata[5];
           Chiamata c1= new Chiamata(321654785, 1);
           Chiamata c2= new Chiamata(321654485, 2);
           Chiamata c3= new Chiamata(321654784, 3);
           Chiamata c4= new Chiamata(321654787, 4);
           Chiamata c5= new Chiamata(321654781, 5);

          chiamata[0]=c1;
          chiamata[1]=c2;
          chiamata[2]=c3;
          chiamata[3]=c4;
          chiamata[4]=c5;

        sim.setChiamata(chiamata);
        sim.stampaDatiSim();

    }
}
