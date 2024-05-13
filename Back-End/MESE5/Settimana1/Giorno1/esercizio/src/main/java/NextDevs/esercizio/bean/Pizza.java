package NextDevs.esercizio.bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data

public class Pizza extends CaloriePrezzo {
    private String nome;
    private List<Topping> toppingList;
}
