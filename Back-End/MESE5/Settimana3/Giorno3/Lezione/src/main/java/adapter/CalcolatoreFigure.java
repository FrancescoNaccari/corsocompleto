package adapter;

import java.util.ArrayList;
import java.util.List;

public class CalcolatoreFigure {
    private List<Figura> figure=new ArrayList<>();

    public void addFigura(Figura figura) {
        this.figure.add(figura);
    }

    public void remove (Figura figura) {
        this.figure.remove(figura);
    }

    public double perimetroTotale() {
       return figure.stream().mapToDouble(Figura::perimetro).sum();
    }

    public double areaTotale() {
        return figure.stream().mapToDouble(Figura::area).sum();
    }
}
