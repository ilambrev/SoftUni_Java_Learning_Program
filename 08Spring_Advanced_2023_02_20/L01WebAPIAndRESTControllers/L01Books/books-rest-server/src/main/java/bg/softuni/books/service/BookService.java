package bg.softuni.books.service;

import bg.softuni.books.model.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookDTO> getAllBooks();

    Optional<BookDTO> findBookById(Long id);

    void deleteBookById(Long id);

    Long createBook(BookDTO bookDTO);

}