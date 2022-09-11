package ru.dawgg.bookmarket.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import ru.dawgg.bookmarket.dto.AuthorDto;
import ru.dawgg.bookmarket.exception.AuthorNotFoundException;
import ru.dawgg.bookmarket.repository.AuthorRepository;
import ru.dawgg.bookmarket.service.AuthorService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final ModelMapper mapper;

    @Override
    @SneakyThrows
    public AuthorDto findAuthorByFullName(String firstName, String lastName) {
        var author = mapper.map(
                authorRepository.findAuthorByNameAndSurname(firstName, lastName),
                AuthorDto.class
        );

        return Optional.ofNullable(author)
                .orElseThrow(AuthorNotFoundException::new);
    }

    @Override
    public List<AuthorDto> findAll() {
        return Streamable.of(authorRepository.findAll())
                .map(author -> mapper.map(author, AuthorDto.class))
                .toList();
    }

    @Override
    @SneakyThrows
    public AuthorDto findOneById(Long id) {
        var authorDto = mapper.map(authorRepository.findById(id), AuthorDto.class);

        return Optional.ofNullable(authorDto)
                .orElseThrow(() -> new AuthorNotFoundException(id));
    }

    @Override
    public List<AuthorDto> findAllByName(String name) {
        return authorRepository.findAllByName(name).stream()
                .map(author -> mapper.map(author, AuthorDto.class))
                .collect(Collectors.toList());
    }
}