package bg.softuni.books.service.impl;

import bg.softuni.books.model.dto.BookDTO;
import bg.softuni.books.model.entity.Author;
import bg.softuni.books.model.entity.Book;
import bg.softuni.books.repository.AuthorRepository;
import bg.softuni.books.repository.BookRepository;
import bg.softuni.books.service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public List<BookDTO> getAllBooks() {
        return this.bookRepository.findAll().stream().map(this::mapToBookDTO).toList();
    }

    @Override
    public Optional<BookDTO> findBookById(Long id) {
        return this.bookRepository.findById(id).map(this::mapToBookDTO);
    }

    @Override
    public void deleteBookById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Long createBook(BookDTO bookDTO) {

        Optional<Author> authorOptional = this.authorRepository.findByName(bookDTO.getAuthor());

        Book book = new Book().setTitle(bookDTO.getTitle())
                .setIsbn(bookDTO.getIsbn())
                .setAuthor(authorOptional.orElseGet(() -> this.authorRepository.save(new Author().setName(bookDTO.getAuthor()))));

        this.bookRepository.flush();

        return this.bookRepository.save(book).getId();
    }

    private BookDTO mapToBookDTO(Book book) {
        return new BookDTO().setId(book.getId())
                .setTitle(book.getTitle())
                .setIsbn(book.getIsbn())
                .setAuthor(book.getAuthor().getName());
    }

}