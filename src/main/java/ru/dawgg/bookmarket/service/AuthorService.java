package ru.dawgg.bookmarket.service;

import ru.dawgg.bookmarket.dto.AuthorDto;
import ru.dawgg.bookmarket.dto.BookDto;
import ru.dawgg.bookmarket.model.Author;

import java.util.List;

public interface AuthorService {
    AuthorDto findAuthorByPersonalData(AuthorDto authorDto);

    List<AuthorDto> findAll();

    AuthorDto findOneById(Long id);
}