package bg.softuni.books.init;

import bg.softuni.books.model.entity.Author;
import bg.softuni.books.model.entity.Book;
import bg.softuni.books.repository.AuthorRepository;
import bg.softuni.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BooksAppInit implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BooksAppInit(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        if (this.authorRepository.count() == 0) {

            createAuthor("Емилиян Станев", new Book().setTitle("Лакомото мече").setIsbn("978-6-19-240374-4"),
                    new Book().setTitle("През води и гори").setIsbn("978-6-19-240435-2"));

            createAuthor("Астрид Линдгрен", new Book().setTitle("Емил от Льонеберя").setIsbn("978-6-19-240511-3"),
                    new Book().setTitle("Пипи Дългото чорапче").setIsbn("978-6-19-240510-6"));

            createAuthor("Елин Пелин", new Book().setTitle("Ян Бибиян, Ян Бибиян на Луната").setIsbn("978-9-54-660278-7"),
                    new Book().setTitle("Приказки").setIsbn("978-6-19-240097-2"));

            createAuthor("Алеко Константинов", new Book().setTitle("Бай Ганьо").setIsbn("978-6-19-240776-6"),
                    new Book().setTitle("До Чикаго и назад").setIsbn("978-6-19-240270-9"));

            createAuthor("Йордан Йовков", new Book().setTitle("Ако можеха да говорят").setIsbn("978-9-54-660172-8"));

            createAuthor("Елисавета Багряна", new Book().setTitle("За вас, деца любими").setIsbn("978-9-54-657304-9"));

        }

    }

    private void createAuthor(String authorName, Book... books) {

        Author author = new Author().setName(authorName);

        List<Book> authorsBooks = Arrays.stream(books).map(book -> book.setAuthor(author)).toList();

        this.authorRepository.save(author.setBooks(authorsBooks));

    }

}