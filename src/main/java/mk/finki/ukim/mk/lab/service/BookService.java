package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<Book> listBooks();
    Author addAuthorToBook(Long authorId, String isbn);
    Book findBookByIsbn(String isbn);
    Map<String,List<String>>listGenre(List<Book>list);
    List<Book>getYears(Integer year);
}
