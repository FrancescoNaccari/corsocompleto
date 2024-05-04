package NextDevs.Entity;

import NextDevs.Dao.CatalogoDao;



import javax.persistence.EntityManager;





public class Archivio  {
    private CatalogoDao catalogoDao;
  //  private List<Catalogo> catalogo=new ArrayList<>();
    public Archivio(EntityManager em){
        this.catalogoDao=new CatalogoDao(em);
    }

    public Archivio(){}


    public void setCatalogoDao(EntityManager em) {
        this.catalogoDao = new CatalogoDao(em);
    }

    public void aggiungiProdotto(Catalogo prodotto){

       if (catalogoDao.getById(prodotto.getCodiceISBN())==null){
           catalogoDao.save(prodotto);
           System.out.println("Aggiunto prodotto all'archivio. ISBN: " + prodotto.getCodiceISBN());
       }else
           catalogoDao.update(prodotto);
        System.out.println("Aggiornato prodotto all'archivio. ISBN: " + prodotto.getCodiceISBN());

    }

    public void rimuoviProdotto(String codiceISBN)throws Exception {
       Catalogo catalogo=catalogoDao.getById(codiceISBN);
       if (catalogo==null){
           throw new Exception("Prodotto non trovato");
    } else {
        catalogoDao.delete(catalogo);
           System.out.println("Prodotto rimosso con successo. ISBN: "+ codiceISBN);
    };
}


//
//    public Optional<Catalogo> cercaPerISBN(String codiceISBN){
//        return catalogo.stream().filter(elemento->elemento.getCodiceISBN().equals(codiceISBN)).findFirst();
//
//    }
//    public List<Catalogo> ricercaPerAnnoPubblicazione(LocalDate data) {
//        return catalogo.stream()
//                .filter(elemento -> elemento.getAnnoPubblicazione().isAfter(data))
//                .collect(Collectors.toList());
//    }
//
//    public List<Catalogo>cercaPerAutore(String autore){
//        return catalogo.stream()
//                .filter(elemento->elemento instanceof Libro && ((Libro) elemento).getAutore().equalsIgnoreCase(autore))
//                .collect(Collectors.toList());
//    }

//
//    @Override
//    public String toString() {
//        return "Archivio{" +
//                "catalogo=" + catalogo +
//                '}';
//    }
}
