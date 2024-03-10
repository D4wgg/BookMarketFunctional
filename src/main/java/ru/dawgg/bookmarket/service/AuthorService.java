package ru.dawgg.bookmarket.service;

import ru.dawgg.bookmarket.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    AuthorDto findAuthorByFullName(String firstName, String lastName);

    List<AuthorDto> findAll();

    AuthorDto findOneById(Long id);

    List<AuthorDto> findAllByName(String name);
}