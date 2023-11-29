package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Book {

    String isbn;
    String title;
    String genre;
    int year;
    List<Author>authors;
    private Long id;
    private BookStore bookStore;

    public Book(String isbn, String title, String genre, int year, List<Author> authors,BookStore bookStore) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.authors = authors;
        this.id=(long)(Math.random()*1000);
        this.bookStore=bookStore;
    }
    public Book(String isbn, String title, String genre, int year,BookStore bookStore) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.id=(long)(Math.random()*1000);
        this.bookStore=bookStore;
        this.authors=new ArrayList<>();

    }
}
