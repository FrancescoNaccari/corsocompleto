package nextdevs;

import java.util.ArrayList;
import java.util.List;
public class Ingrediente {
    private String nome;
    private int kcal;
    private List<Ingrediente> ingredienti;

    public Ingrediente(String nome, int kcal) {
        this.nome = nome;
        this.kcal = kcal;
        this.ingredienti = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

}
