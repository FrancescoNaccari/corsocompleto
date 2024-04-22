package it.nextdevs.lezione;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsaAritmetica {
   static Logger logger= LoggerFactory.getLogger("logger1");

   //TRACE<DEBUG<INFO<WARN<ERROR

    public static void main(String[] args) {

        logger.warn("Sto lanciando l'applicazione");

        Aritmetica aritmetica=new Aritmetica();
        try {
            System.out.println(aritmetica.divisione(5,3));
        }catch (ArithmeticException e ) {
            System.out.println("Divisione per 0 non ammessa");
        }catch (DivisionePer0Exception e) {
            System.out.println(e.getMessage());
          //  e.printStackTrace();
        }catch (Exception e){
            System.out.println("gestione generica dell'eccezione");
        }
        logger.info("Sto terminando l'applicazione");

    }
}
