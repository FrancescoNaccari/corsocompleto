package it.epicode.esercizio2;


public class DipendenteFullTime extends Dipendente{
    private double bonus;

    public DipendenteFullTime(String matricola, double stipendio, Dipartimento dipartimento, double bonus) {
        super(matricola, stipendio,dipartimento);
    this.bonus=bonus;
    }

    @Override
    public double calculateSalary() {
        return this.getStipendio()+this.bonus;
    }
}
