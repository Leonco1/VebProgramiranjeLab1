package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAuthors();
    public Optional<Author> findById(Long id);
    void Add(Long id);
    public Optional<Author>Save(Long id,String name,String surname,String biography);
    public void DeleteById(Long Id);
}

