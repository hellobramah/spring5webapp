package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;

    }

    @Override
    public void run(String... args) throws Exception {


        //Should have name and address (Address line 1, city, state, zip)
        Publisher publisher1 = new Publisher();

        publisher1.setName("Rivers Inc");
        publisher1.setAddressLine1("Galgamarken 3");
        publisher1.setCity("Karlskrona");
        publisher1.setState("Blekinge");
        publisher1.setZip("00360");
        publisherRepository.save(publisher1);

        Author author1 = new Author("Richard", "Christian");
        Book book1 = new Book("Rat Race", "1234567");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        book1.setPublisher(publisher1);
        publisher1.getBooks().add(book1);

        authorRepository.save(author1);
        bookRepository.save(book1);
        publisherRepository.save(publisher1);


        Author author2 = new Author("Bob", "Marley");
        Book book2 = new Book("We Jammmin", "2536789");
        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);
        book2.setPublisher(publisher1);
        publisher1.getBooks().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher1);




        System.out.println("Started in bootstrap");
        System.out.println("Number of books " + bookRepository.count());
        System.out.println("Number of publishers " + publisherRepository.count());
        System.out.println("Publisher Number of Books: " + publisher1.getBooks().size());


    }
}
