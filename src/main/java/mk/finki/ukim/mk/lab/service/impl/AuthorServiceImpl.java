package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.exceptions.NotFoundException;
import mk.finki.ukim.mk.lab.repository.AuthorRepository;
import mk.finki.ukim.mk.lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> listAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id)  {
        return authorRepository.findById(id);
    }

    @Override
    public void Add(Long id) {
        Author a=authorRepository.findById(id).get();
        authorRepository.findAll().remove(a);
        authorRepository.findAll().add(a);

    }

    @Override
    public Optional<Author> Save(Long id, String name, String surname, String biography) {
        return authorRepository.Save(id,name,surname,biography);
    }

    @Override
    public void DeleteById(Long Id) {
        this.authorRepository.DeleteById(Id);
    }
}
