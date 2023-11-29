package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.BookStore;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class BookRepository {
    private  final BookStoreRepository bookStoreRepository;

    public BookRepository(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    public List<Book> findAll()
    {
        return DataHolder.books;
    }
    public Book findByIsbn(String isbn)
    {
        return DataHolder.books.stream().filter(i->i.getIsbn().equals(isbn)).findFirst().orElse(null);
    }
    public Optional<Book> findById(Long id)
    {
        return DataHolder.books.stream().filter(i->i.getId().equals(id)).findFirst();
    }
    public Author addAuthorToBook(Author author, Book book)
    {
        List<Book>bookList=findAll();

        if (author != null)
        {
            book.getAuthors().remove(author);
            book.getAuthors().add(author);
        }
        bookList.removeIf(i-> i.getIsbn().equals(book.getIsbn()));
        bookList.add(book);
        return author;
    }
    public void DeleteById(Long Id)
    {
        DataHolder.books.removeIf(i->i.getId().equals(Id));
    }
    public Map<String,List<String>> listGenres()
    {

        return DataHolder.map;
    }
    public Optional<Book>Save(String title,String isbn,String genre,Integer year,Long Id)
    {
        BookStore bookStore=bookStoreRepository.findByID(Id).get();

        Book book=new Book(isbn,title,genre,year,bookStore);
        DataHolder.books.removeIf(i->i.getIsbn().equals(book.getIsbn()));
        DataHolder.books.add(book);
        return Optional.of(book);
    }
}
