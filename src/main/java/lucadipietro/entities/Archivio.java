package lucadipietro.entities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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

    public void rimuoviElementoPerISBN(Long ISBN) {
        Iterator<ElementoCatalogo> iterator = catalogo.iterator();
        while (iterator.hasNext()) {
            ElementoCatalogo elemento = iterator.next();
            if (elemento.getISBN().equals(ISBN)) {
                iterator.remove();
                System.out.println("Elemento rimosso con successo.");
                return;
            }
        }
        System.out.println("Elemento non trovato con il codice ISBN specificato.");
    }

    public List<ElementoCatalogo> ricercaPerISBN(Long ISBN) {
        return catalogo.stream().filter(elementoCatalogo -> elementoCatalogo.getISBN().equals(ISBN)).toList();
    }

    public List<ElementoCatalogo> ricercaPerAnno(int anno) {
        return catalogo.stream().filter(elementoCatalogo -> elementoCatalogo.getAnnoPubblicazione().equals(anno)).toList();
    }

    public List<ElementoCatalogo> ricercaPerAutore(String autore) {
        return catalogo.stream().filter(elementoCatalogo -> elementoCatalogo instanceof Libro && ((Libro) elementoCatalogo).getAutore().equalsIgnoreCase(autore)).toList();
    }

    public void salvataggioSuDisco() throws IOException {
        StringBuilder toWrite = new StringBuilder();

        for (ElementoCatalogo elementoCatalogo : catalogo) {
            toWrite.append(elementoCatalogo.toString()).append(System.lineSeparator());
        }

        File file = new File("Archivio.txt");
        FileUtils.writeStringToFile(file, toWrite.toString(), "UTF-8");
    }
    
}
//    public List<ElementoCatalogo> caricamentoDalDisco() throws IOException {
//        File file = new File("Archivio.txt");
//
//        String fileString = FileUtils.readFileToString(file, "UTF-8");
//    }