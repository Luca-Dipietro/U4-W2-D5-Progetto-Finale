package lucadipietro.entities;

public abstract class ElementoCatalogo {
    private Long ISBN;
    private String titolo;
    private Integer annoPubblicazione;
    private Integer numeroPagine;

    public ElementoCatalogo(Long ISBN, String titolo, Integer annoPubblicazione, Integer numeroPagine) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Integer getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(Integer annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public Integer getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(Integer numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "ElementoCatalogo {" +
                "ISBN = " + ISBN +
                ", titolo = '" + titolo + '\'' +
                ", annoPubblicazione = " + annoPubblicazione +
                ", numeroPagine = " + numeroPagine +
                '}';
    }
}
