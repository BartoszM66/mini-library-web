package org.BartoszM.weblibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final AuthorRepository authorRepository;

    public DataInitializer(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) {
        if (authorRepository.count() == 0) {
            Author author1 = new Author();
            author1.setFirstName("Stephen");
            author1.setLastName("King");

            Book book1 = new Book();
            book1.setTitle("Lśnienie");
            book1.setAuthor(author1);

            Book book2 = new Book();
            book2.setTitle("Zielona Mila");
            book2.setAuthor(author1);

            author1.getBooks().add(book1);
            author1.getBooks().add(book2);

            authorRepository.save(author1);

            System.out.println("Dane testowe załadowane!");
        }
    }
}
