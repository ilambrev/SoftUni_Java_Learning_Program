package bg.softuni.books.model.dto;

public class BookDTO {

    private Long id;

    private String title;

    private String isbn;

    private String author;

    public BookDTO() {

    }

    public Long getId() {
        return id;
    }

    public BookDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookDTO setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BookDTO setAuthor(String author) {
        this.author = author;
        return this;
    }

}