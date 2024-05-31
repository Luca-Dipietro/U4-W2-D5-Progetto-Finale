package lucadipietro;

import com.github.javafaker.Faker;
import lucadipietro.entities.Archivio;
import lucadipietro.entities.Libro;
import lucadipietro.entities.Rivista;
import lucadipietro.enums.Periodicità;

import java.io.IOException;
import java.util.Locale;
import java.util.function.Supplier;

public class Application {

    public static void main(String[] args) {

        Faker faker = new Faker(Locale.ITALY);

        Archivio catalogo = new Archivio();

        Supplier<Libro> libroSupplier = () -> {
            try {
                return new Libro(Long.parseLong(faker.code().isbn13()),
                        faker.book().title(),
                        faker.number().numberBetween(1900, 2024),
                        faker.number().numberBetween(100, 1500),
                        faker.book().author(),
                        faker.book().genre()
                );
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Errore durante la generazione di un libro: " + e.getMessage());
            }
        };

        Supplier<Rivista> rivistaSupplier = () -> {
            try {
                return new Rivista(Long.parseLong(faker.code().isbn13()),
                        faker.book().title(),
                        faker.number().numberBetween(2000, 2024),
                        faker.number().numberBetween(40, 150),
                        Periodicità.values()[faker.number().numberBetween(0, Periodicità.values().length)]
                );
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                throw new RuntimeException("Errore durante la generazione di una rivista: " + e.getMessage());
            }
        };

        for (int i = 0; i < 10; i++) {
            catalogo.aggiungiElemento(libroSupplier.get());
        }

        for (int i = 0; i < 10; i++) {
            catalogo.aggiungiElemento(rivistaSupplier.get());
        }

        try {
            catalogo.salvataggioSuDisco();
            System.out.println("Archivio salvato su disco");
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio su disco" + e.getMessage());
        }

//        System.out.println("TEST");
//        System.out.println("Catalogo Bibliotecario");
//        catalogo.aggiungiElemento(new Libro(9783161484100L, "Il signore degli anelli", 1954, 1178, "J.R.R. Tolkien", "Fantasy"));
//        catalogo.aggiungiElemento(new Libro(9788804668236L, "1984", 1949, 328, "George Orwell", "Distopia"));
//        catalogo.aggiungiElemento(new Rivista(9788817126802L, "National Geographic", 1999, 120, Periodicità.MENSILE));
//        catalogo.aggiungiElemento(new Rivista(9788868390250L, "Scientific American", 1845, 82, Periodicità.MENSILE));
//        catalogo.getCatalogo().forEach(System.out::println);
//        System.out.println();
//        Long isbnToSearch = 9783161484100L;
//        List<ElementoCatalogo> risultatiISBN = catalogo.ricercaPerISBN(isbnToSearch);
//        System.out.println("Risultati della ricerca per ISBN " + isbnToSearch + ":");
//        System.out.println(risultatiISBN);
//        System.out.println();
//        int annoToSearch = 1999;
//        List<ElementoCatalogo> risultatiAnno = catalogo.ricercaPerAnno(annoToSearch);
//        System.out.println("Risultati della ricerca per anno " + annoToSearch + ":");
//        System.out.println(risultatiAnno);
//        System.out.println();
//        String autoreToSearch = "J.R.R. Tolkien";
//        List<ElementoCatalogo> risultatiAutore = catalogo.ricercaPerAutore(autoreToSearch);
//        System.out.println("Risultati della ricerca per autore " + autoreToSearch + ":");
//        System.out.println(risultatiAutore);
//        System.out.println();
//        Long isbnToRemove = 9788804668236L;
//        System.out.println("Rimozione dell'elemento con ISBN " + isbnToRemove + ":");
//        catalogo.rimuoviElementoPerISBN(isbnToRemove);
//        catalogo.getCatalogo().forEach(System.out::println);
    }
}
