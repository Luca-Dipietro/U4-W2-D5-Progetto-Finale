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

//        System.out.println("Catalogo Bibliotecario");
//        catalogo.getCatalogo().forEach(System.out::println);

        try {
            catalogo.salvataggioSuDisco();
            System.out.println("Archivio salvato su disco");
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio su disco" + e.getMessage());
        }
    }
}
