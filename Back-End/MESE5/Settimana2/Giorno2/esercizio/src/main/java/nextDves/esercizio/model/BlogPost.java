package nextDves.esercizio.model;


import lombok.Data;

import java.sql.Time;
import java.time.Duration;

@Data
public class BlogPost {

    private int id;
    private static int contatore;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private Duration tempoDiLettura;

    public BlogPost(Duration tempoDiLettura, String categoria,String contenuto, String titolo) {
        this.tempoDiLettura = tempoDiLettura;
        this.categoria = categoria;
        this.cover = "https://picsum.photos/200/300";
        this.titolo = titolo;
        this.contenuto = contenuto;
        contatore++;
        id = contatore;
    }
}
