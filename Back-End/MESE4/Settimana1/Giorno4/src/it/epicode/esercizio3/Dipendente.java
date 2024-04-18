package it.epicode.esercizio3;


public abstract class Dipendente implements DipendenteI{

   private String matricola;
   private double stipendio;
   private Dipartimento dipartimento;

   public Dipendente(String matricola, double stipendio, Dipartimento dipartimento) {
      this.matricola = matricola;
      this.stipendio = stipendio;
      this.dipartimento = dipartimento;

   }

   public String getMatricola() {
      return this.matricola;
   }


   public double getStipendio() {
      return this.stipendio;
   }


   public Dipartimento getDipartimento() {
      return dipartimento;
   }

   public void setDipartimento(Dipartimento dipartimento) {
      this.dipartimento = dipartimento;
   }

public abstract double calculateSalary();

   @Override
   public void checkIn() {
      System.out.println(this.matricola+" è entrato in servizio");
   }
}
