package it.nextdevs.esercizio2;



public class CalcoConsumo {

    public CalcoConsumo() {
    }

    public double consumo(double km , double litri) throws DivisionePer0Exception {

        double consumoEffettuato;

        if (litri==0){
            throw new DivisionePer0Exception("Divisione per 0 non ammessa");
        }else {
            consumoEffettuato=km/litri;

        }
        return consumoEffettuato;
    }



}

