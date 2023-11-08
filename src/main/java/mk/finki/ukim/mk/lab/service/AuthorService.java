package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.NotFoundException;

import java.util.List;

public interface AuthorService {
    List<Author> listAuthors();
    Author findById(Long id) throws NotFoundException;
    void Add(Long id);
}

