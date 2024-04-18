package it.epicode.esercizio3;


public class DipendenteFullTime extends Dipendente {
    private double bonus;

    public DipendenteFullTime(String matricola, double stipendio, Dipartimento dipartimento, Double bonus) {
        super(matricola, stipendio,dipartimento);
        this.bonus=bonus;
    }

    @Override
    public double calculateSalary() {
        return this.getStipendio();
    }
}
