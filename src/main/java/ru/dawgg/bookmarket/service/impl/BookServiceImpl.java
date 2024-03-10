package ru.dawgg.bookmarket.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import ru.dawgg.bookmarket.dto.BookDto;
import ru.dawgg.bookmarket.exception.BookNotFoundException;
import ru.dawgg.bookmarket.model.Book;
import ru.dawgg.bookmarket.model.BookGenre;
import ru.dawgg.bookmarket.repository.BookRepository;
import ru.dawgg.bookmarket.service.BookService;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<BookDto> findAll() {
        return Streamable.of(repository.findAll())
                .map(book -> mapper.map(book, BookDto.class))
                .toList();
    }

    @Override
    @SneakyThrows
    public BookDto findOne(Long id) {
        var book = mapper.map(repository.findById(id), BookDto.class);

        return Optional.ofNullable(book)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public void save(BookDto bookDto) {
        repository.save(mapper.map(bookDto, Book.class));
    }

    @Override
    public List<BookDto> findAllReleasedAfter(LocalDate date) {
        return findAll().stream()
                .filter(bookDto -> bookDto.getReleaseDate().isAfter(date))
                .sorted(Comparator.comparing(BookDto::getReleaseDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findAllReleasedBefore(LocalDate date) {
        return findAll().stream()
                .filter(bookDto -> bookDto.getReleaseDate().isAfter(date))
                .sorted(Comparator.comparing(BookDto::getReleaseDate).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> sortBooksByPrice() {
        return findAll().stream()
                .sorted(Comparator.comparing(BookDto::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> sortBooksByPriceReversed() {
        return findAll().stream()
                .sorted(Comparator.comparing(BookDto::getPrice).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> filterBooksByGenre(BookGenre genre) {
        return findAll().stream()
                .filter(bookDto -> bookDto.getGenre().equals(genre.name()))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> sortBooksByReleaseDate() {
        return findAll().stream()
                .sorted(Comparator.comparing(BookDto::getReleaseDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> sortBooksByReleaseDateReversed() {
        return findAll().stream()
                .sorted(Comparator.comparing(BookDto::getReleaseDate).reversed())
                .collect(Collectors.toList());
    }
}