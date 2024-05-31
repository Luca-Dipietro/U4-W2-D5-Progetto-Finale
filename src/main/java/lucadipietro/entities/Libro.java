package lucadipietro.entities;

public class Libro extends ElementoCatalogo {

    private String autore;
    private String genere;

    public Libro(Long ISBN, String titolo, Integer annoPubblicazione, Integer numeroPagine, String autore, String genere) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro {" +
                "autore = '" + autore + '\'' +
                ", genere = '" + genere + '\'' +
                '}' + " " + super.toString();
    }
}
