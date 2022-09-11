package ru.dawgg.bookmarket.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dawgg.bookmarket.model.Author;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Optional<Author> findAuthorByNameAndSurname(String name, String surname);
    List<Author> findAllByName(String name);
}