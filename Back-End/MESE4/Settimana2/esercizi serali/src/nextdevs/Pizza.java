package nextdevs;


import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String nome;
    private Double prezzo;
    private List<Ingrediente> ingredienti;


    public Pizza(String nome, Double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.ingredienti =new ArrayList<>();

    }

    public String getNome() {
        return nome;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public List<Ingrediente> getIngredienti() {
        return ingredienti;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }


    public void aggiungiIngrediente(Ingrediente ingrediente) {
        ingredienti.add(ingrediente);
    }

    public int kilocalorie() {
        int kcalTotale = 0;
        for (Ingrediente ingrediente : ingredienti) {
            kcalTotale += ingrediente.getKcal();
        }
        return kcalTotale;
    }

}
