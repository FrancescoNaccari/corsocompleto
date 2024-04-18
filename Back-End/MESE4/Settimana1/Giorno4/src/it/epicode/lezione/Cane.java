package it.epicode.lezione;

public class Cane extends Animale implements MezzoDiTrasporto{
    private String razza;


    public Cane(String razza,String nome,int zampe) {
        super(nome,zampe);
        this.razza = razza;
    }


    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }

    @Override
    public String visualizzaDati() {
        return super.visualizzaDati()+", razza: "+razza;
    }

    @Override
    public void verso() {
        System.out.println("bauuu");
    }

    @Override
    public void tipoTrasporto() {
        System.out.println("Il cane traina una slitta");
    }
}
