package lucadipietro;

import com.github.javafaker.Faker;
import lucadipietro.entities.Archivio;
import lucadipietro.entities.Libro;
import lucadipietro.entities.Rivista;
import lucadipietro.enums.Periodicità;

import java.util.Locale;

public class Application {

    public static void main(String[] args) {

        Faker faker = new Faker(Locale.ITALY);

        Archivio catalogo = new Archivio();

        for (int i = 0; i < 10; i++) {
            Libro libro = new Libro(Long.parseLong(faker.code().isbn13()),
                    faker.book().title(),
                    faker.number().numberBetween(1900, 2024),
                    faker.number().numberBetween(100, 1500),
                    faker.book().author(),
                    faker.book().genre());
            catalogo.aggiungiElemento(libro);
        }

        for (int i = 0; i < 10; i++) {
            Rivista rivista = new Rivista(Long.parseLong(faker.code().isbn13()),
                    faker.book().title(),
                    faker.number().numberBetween(2000, 2024),
                    faker.number().numberBetween(40, 150),
                    Periodicità.values()[faker.number().numberBetween(0, Periodicità.values().length)]);
            catalogo.aggiungiElemento(rivista);
        }

        catalogo.getCatalogo().forEach(System.out::println);
    }
}
