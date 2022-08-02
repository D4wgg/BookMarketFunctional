package ru.dawgg.bookmarket.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.dawgg.bookmarket.dto.AuthorDto;
import ru.dawgg.bookmarket.exception.ApiEntityNotFoundException;
import ru.dawgg.bookmarket.model.Author;
import ru.dawgg.bookmarket.repository.AuthorRepository;
import ru.dawgg.bookmarket.service.AuthorService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.dawgg.bookmarket.exception.ApiEntityNotFoundException.AUTHOR_NOT_FOUND_EXCEPTION;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final ModelMapper mapper;

    @Override
    public AuthorDto findAuthorByPersonalData(AuthorDto authorDto) {
        AuthorDto author = mapper.map(
                authorRepository.findAuthorByNameAndSurname(authorDto.getName(), authorDto.getSurname()),
                AuthorDto.class
        );

        return Optional.ofNullable(author)
                .orElseThrow(new ApiEntityNotFoundException(AUTHOR_NOT_FOUND_EXCEPTION));
    }

    @Override
    public List<AuthorDto> findAll() {
        List<Author> authors = (List<Author>) authorRepository.findAll();

        return authors.stream()
                .map(author -> mapper.map(author, AuthorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDto findOneById(Long id) {
        AuthorDto authorDto = mapper.map(authorRepository.findById(id), AuthorDto.class);

        return Optional.ofNullable(authorDto)
                .orElseThrow(new ApiEntityNotFoundException(AUTHOR_NOT_FOUND_EXCEPTION));
    }
}