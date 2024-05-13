package NextDevs.esercizio.bean;

import lombok.Data;
import lombok.ToString;

@Data
public class Drink extends CaloriePrezzo {
    private String nome;
    private double ml;
    private int gradoAlcohol;

    public Drink() {
    }
}
