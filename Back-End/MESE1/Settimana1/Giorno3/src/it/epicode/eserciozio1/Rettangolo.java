package it.epicode.eserciozio1;

public class Rettangolo {
    private double altezza;
    private double larghezza;
    private double perimetro;
    private double area;

    public Rettangolo(double altezza, double larghezza) {
        this.altezza = altezza;
        this.larghezza = larghezza;
    }

    public void perimetro(){

        perimetro= (altezza+larghezza)*2;

    }

    public double getPerimetro() {
        return perimetro;
    }

    public void area(){
        area=altezza*larghezza;
    }

    public double getArea() {
        return area;
    }

    public static double sommaAree(Rettangolo r1, Rettangolo r2){
        return r1.getArea()+r2.getArea();
    }
    public static double sommaPerimetri(Rettangolo r1, Rettangolo r2){
        return r1.getPerimetro()+r2.getPerimetro();
    }



}
