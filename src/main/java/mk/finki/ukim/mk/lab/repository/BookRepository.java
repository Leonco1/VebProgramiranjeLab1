package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {
    public List<Book> findAll()
    {
        return DataHolder.books;
    }
    public Book findByIsbn(String isbn)
    {
        return DataHolder.books.stream().filter(i->i.getIsbn().equals(isbn)).findFirst().orElse(null);
    }
    public Author addAuthorToBook(Author author, Book book)
    {
        List<Book>bookList=findAll();
        if (author != null && book != null)
        {
            book.getAuthors().remove(author);
            book.getAuthors().add(author);
        }
        bookList.removeIf(i-> {
            return i.getIsbn().equals(book.getIsbn());
        });
        bookList.add(book);
        return author;
    }

    public Map<String,List<String>> listGenres()
    {

        return DataHolder.map;
    }
}
