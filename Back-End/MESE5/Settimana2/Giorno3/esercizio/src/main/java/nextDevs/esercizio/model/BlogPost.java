package nextDevs.esercizio.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Duration;

@Data
@Entity
public class BlogPost {
    @Id
    @GeneratedValue
    private int id;
//    private static int contatore;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private Duration tempoDiLettura;

    @ManyToOne
    @JoinColumn(name = "autore_id")
    @JsonIgnore
    private Autore autore;

//    public BlogPost(Duration tempoDiLettura, String categoria,String contenuto, String titolo) {
//        this.tempoDiLettura = tempoDiLettura;
//        this.categoria = categoria;
//        this.cover = "https://picsum.photos/200/300";
//        this.titolo = titolo;
//        this.contenuto = contenuto;
//        contatore++;
//        id = contatore;
//    }
}
