package it.epicode.lezione;

public class UsaPersona {
    public static void main(String[] args) {
        Persona p= new Persona("Francesco","Naccari",31,TipoLavoro.PROGRAMMATORE);

        System.out.println(p.getNome());
        System.out.println(p.getCognome());
        System.out.println(p.getEta());

        System.out.println(p.contatore);
        System.out.println();//come se fosse un (br)

        Persona p2=new Persona("Pino","Lavatrice" );
        System.out.println(p2.getNome());
        System.out.println(p2.getCognome());
        System.out.println(p2.getEta());

        System.out.println(p2.contatore);
        System.out.println();//come se fosse un (br)

        Persona p3=new Persona("Gigi","Nomade");
        System.out.println(Persona.contatore);
        System.out.println(Persona.contatore);
        System.out.println(Persona.contatore);


        p=null;//p non è più collegato all'oggetto

        p=p2;// stiamo collegando p all'oggetto di p2

        p.setNome("Ginevra");
        System.out.println(p2.getNome());
        System.out.println();//come se fosse un (br)

        System.out.println(p==p2);
        System.out.println(p.equals(p2));

        p2=null; //p2 non è più collegato all'oggetto
                 // p continua ad avere le caratterista dell'oggetto (p2)
        p.setNome("fra");
        System.out.println(p.getNome());
       // System.out.println(p2.getNome()); //cosi risulta null error


        p2=new Persona("Nino","Lava" );
        System.out.println(p2.getNome());

        System.out.println(p==p2);
        System.out.println(p.equals(p2));



    }


}
