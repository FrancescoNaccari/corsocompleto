package it.nextdevs.esercizio.bean;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(callSuper = true)
public class Drink extends CaloriePrezzo{
    private String nome;
    private Double litri;
    private Integer gradoAlcool;
}
