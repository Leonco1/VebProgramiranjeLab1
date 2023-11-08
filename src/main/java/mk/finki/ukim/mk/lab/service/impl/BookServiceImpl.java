package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.repository.AuthorRepository;
import mk.finki.ukim.mk.lab.repository.BookRepository;
import mk.finki.ukim.mk.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Author addAuthorToBook(Long authorId, String isbn) {
        Author author=authorRepository.findById(authorId).orElse(null);
        Book book=bookRepository.findByIsbn(isbn);
       return bookRepository.addAuthorToBook(author,book);

    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public Map<String, List<String>> listGenre(List<Book>list) {
       return bookRepository.listGenres();

    }

    @Override
    public List<Book> getYears(Integer year) {
       return listBooks().stream().filter(book -> {
            Integer yearr=book.getYear();
            return yearr.equals(year);
        }).collect(Collectors.toList());

    }


    public BookServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
}
