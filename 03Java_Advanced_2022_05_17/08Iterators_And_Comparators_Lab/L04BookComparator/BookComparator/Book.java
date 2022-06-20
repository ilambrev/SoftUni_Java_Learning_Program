package BookComparator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = Arrays.asList(authors);
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public int compareTo(Book other) {
        int result = this.title.compareTo(other.title);

        if (result == 0) {
            result = Integer.compare(this.year, other.year);
        }

        return result;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, ", this.title, this.year) +
                this.authors.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

}