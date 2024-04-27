package NextDevs;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Archivio  {
    private List<Catalogo> catalogo =new ArrayList<>();



    public void aggiungiProdotto(Catalogo prodotto){
    catalogo.add(prodotto);
    }

    public boolean rimuoviProdotto(String codiceISBN){
        return catalogo.removeIf(elemento->elemento.getCodiceISBN().equals(codiceISBN));
    }

    public Optional<Catalogo> cercaPerISBN(String codiceISBN){
        return catalogo.stream().filter(elemento->elemento.getCodiceISBN().equals(codiceISBN)).findFirst();

    }
    public List<Catalogo> ricercaPerAnnoPubblicazione(LocalDate data) {
        return catalogo.stream()
                .filter(elemento -> elemento.getAnnoPubblicazione().isAfter(data))
                .collect(Collectors.toList());
    }

    public List<Catalogo>cercaPerAutore(String autore){
        return catalogo.stream()
                .filter(elemento->elemento instanceof Libro && ((Libro) elemento).getAutore().equalsIgnoreCase(autore))
                .collect(Collectors.toList());
    }


    public void salvaSulDisco(String nomeFile)throws IOException{
        String data= catalogo.stream()
                .map(elemento->{
            if(elemento instanceof Libro){
               return elemento.libro((Libro) elemento);
            }else if (elemento instanceof Rivista){
                return elemento.rivista((Rivista) elemento);
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.joining(System.lineSeparator()));
        FileUtils.writeStringToFile(new File(nomeFile),data,"UTF-8");
    }

    public List<Catalogo> caricamentoSulDisco(String nomeFile)throws IOException{
        List<String>lines=FileUtils.readLines(new File(nomeFile),"UTF-8");
        return lines.stream().map(line->{
            String[] parts = line.split(",");
            if (parts.length==6){

                String codiceISBN=parts[0];
                String titolo=parts[1];
                LocalDate annoPubblicazione=LocalDate.parse(parts[2]);
                int numeroPagine=Integer.parseInt(parts[3]);
                String autore=parts[4];
                String genere=parts[5];

                return new  Libro(codiceISBN,titolo,annoPubblicazione,numeroPagine,autore,genere);
            } else if (parts.length==5) {
                String codiceISBN=parts[0];
                String titolo=parts[1];
                LocalDate annoPubblicazione=LocalDate.parse(parts[2]);
                int numeroPagine=Integer.parseInt(parts[3]);
                String periodicita=parts[4];

                if (periodicita!=null) {
                    return new Rivista(codiceISBN, titolo, annoPubblicazione, numeroPagine,
                            Periodicita.formatoStringa(periodicita));
                }
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

}
