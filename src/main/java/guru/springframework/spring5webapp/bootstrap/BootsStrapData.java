package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sun.tools.jar.CommandLine;

@Component
public class BootsStrapData implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private   BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "123123");

    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepository.save(ddd);

    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "323434343");

    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        System.out.println("Started in Bootstreap");
        System.out.println("Number of books: " + bookRepository.count());

    }
}
