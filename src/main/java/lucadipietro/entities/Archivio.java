package lucadipietro.entities;

import java.util.ArrayList;
import java.util.List;

public class Archivio {

    private List<ElementoCatalogo> catalogo;

    public Archivio() {
        this.catalogo = new ArrayList<>();
    }

    public List<ElementoCatalogo> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<ElementoCatalogo> catalogo) {
        this.catalogo = catalogo;
    }

    public void aggiungiElemento(ElementoCatalogo elemento) {
        catalogo.add(elemento);
    }
}
