package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.BookStore;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class AuthorRepository {

    public List<Author> findAll()
    {
        return DataHolder.authors;
    }
    public Optional<Author> findById(Long id)
    {
        return DataHolder.authors.stream().filter(i->i.getId().equals(id)).findFirst();
    }

    public Optional<Author>Save(Long id, String name, String surname,String biography)
    {

        Author author=new Author(id,name,surname,biography);
        DataHolder.authors.removeIf(i->i.getId().equals(author.getId()));
        DataHolder.authors.add(author);
        return Optional.of(author);
    }
    public void DeleteById(Long Id)
    {
        DataHolder.authors.removeIf(i->i.getId().equals(Id));
    }
}
