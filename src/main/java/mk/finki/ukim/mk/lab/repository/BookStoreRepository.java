package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.BookStore;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@Repository
public class BookStoreRepository {

    public List<BookStore> findAll()
    {
        return DataHolder.bookStores;
    }
    public Optional<BookStore>findByID(Long id)
    {
        return DataHolder.bookStores.stream().filter(i->i.getId().equals(id)).findFirst();
    }
}
