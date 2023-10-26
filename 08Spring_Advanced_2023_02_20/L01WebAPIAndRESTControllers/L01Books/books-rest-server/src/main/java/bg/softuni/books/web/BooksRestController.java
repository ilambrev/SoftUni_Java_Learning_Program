package bg.softuni.books.web;

import bg.softuni.books.model.dto.BookDTO;
import bg.softuni.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/books")
public class BooksRestController {

    private final BookService bookService;

    @Autowired
    public BooksRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return ResponseEntity.ok(this.bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findBookById(@PathVariable("id") Long bookId) {

        Optional<BookDTO> bookDTOOptional = this.bookService.findBookById(bookId);

        return bookDTOOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable("id") Long bookId) {

        this.bookService.deleteBookById(bookId);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody BookDTO bookDTO,
                                              UriComponentsBuilder uriComponentsBuilder) {

        Long bookId = this.bookService.createBook(bookDTO);

        return ResponseEntity.created(uriComponentsBuilder.path("/api/books/{id}").build(bookId))
                .build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateBook(@RequestBody BookDTO bookDTO,
                                              @PathVariable("id") Long bookId,
                                              UriComponentsBuilder uriComponentsBuilder) {

        return this.bookService.updateBookInfo(bookDTO.setId(bookId)) ?
                ResponseEntity.ok("Book successfully updated!") : ResponseEntity.notFound().build();
    }

}