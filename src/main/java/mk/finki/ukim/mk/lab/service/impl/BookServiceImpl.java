package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.BookStore;
import mk.finki.ukim.mk.lab.repository.jpa.AuthorRepository;
import mk.finki.ukim.mk.lab.repository.jpa.BookRepository;
import mk.finki.ukim.mk.lab.repository.jpa.BookStoreRepository;
import mk.finki.ukim.mk.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final BookStoreRepository bookStoreRepository;

    public BookServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository,BookStoreRepository bookStoreRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.bookStoreRepository=bookStoreRepository;
    }

    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Author addAuthorToBook(Long authorId, String isbn) {
        Author author= authorRepository.findById(authorId).orElse(null);
        Book book=bookRepository.findByIsbn(isbn);
        List<Book>bookList=bookRepository.findAll();
        if (author != null)
        {
            book.getAuthors().remove(author);
            book.getAuthors().add(author);
        }
        bookList.removeIf(i-> i.getIsbn().equals(book.getIsbn()));
        bookList.add(book);
       return this.authorRepository.save(author);

    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

//    @Override
//    public Map<String, List<String>> listGenre(List<Book>list) {
//       return bookRepository.listGenres();
//
//    }
    @Override
    public void DeleteById(Long bookId)
    {
        Optional<Book> deleteBook = bookRepository.findById((long)bookId);
        if (deleteBook.isEmpty()){
            throw new IllegalArgumentException();
        }

        bookRepository.delete(deleteBook.get());
    }

    @Override
    public List<Book> getYears(Integer year) {
       return listBooks().stream().filter(book -> {
            Integer yearr=book.getYear();
            return yearr.equals(year);
        }).collect(Collectors.toList());

    }

    @Override
    public Optional<Book> Save(String title, String isbn, String genre, Integer year, Long Id) {
        BookStore bookStore=bookStoreRepository.findById(Id).get();
        return Optional.of(this.bookRepository.save(new Book(isbn,title,genre,year,bookStore)));
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }



}
