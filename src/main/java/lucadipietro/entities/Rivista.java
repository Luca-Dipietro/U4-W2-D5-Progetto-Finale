package lucadipietro.entities;

import lucadipietro.enums.Periodicità;

public class Rivista extends ElementoCatalogo {

    private Periodicità periodicità;

    public Rivista(Long ISBN, String titolo, Integer annoPubblicazione, Integer numeroPagine, Periodicità periodicità) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Rivista {" + super.toString() +
                ", periodicità = " + periodicità +
                '}';
    }
}
