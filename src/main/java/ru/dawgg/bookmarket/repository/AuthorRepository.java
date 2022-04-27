package ru.dawgg.bookmarket.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dawgg.bookmarket.model.Author;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    Optional<Author> findAuthorByNameAndSurnameAndBirthDate(String name, String surname, LocalDate birthDate);
}