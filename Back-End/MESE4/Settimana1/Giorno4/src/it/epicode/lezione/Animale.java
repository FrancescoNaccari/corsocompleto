package it.epicode.lezione;

public abstract class Animale {
    private int zampe;
    private String nome;

    public Animale(int zampe, String nome) {
        this.zampe = zampe;
        this.nome = nome;
    }


    public Animale(String nome) {
        this.nome=nome;
    }

    public Animale( String nome,int zampe) {
        this.zampe = zampe;
        this.nome = nome;
    }

    public int getZampe() {
        return zampe;
    }

    public void setZampe(int zampe) {
        this.zampe = zampe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String visualizzaDati(){
        return "Nome: "+nome+", zampe: "+zampe;
    }

    public abstract void verso();

}
