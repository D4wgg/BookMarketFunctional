package ru.dawgg.bookmarket.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.dawgg.bookmarket.dto.BookDto;
import ru.dawgg.bookmarket.exception.ApiEntityNotFoundException;
import ru.dawgg.bookmarket.model.Book;
import ru.dawgg.bookmarket.model.characteristic.BookGenre;
import ru.dawgg.bookmarket.repository.BookRepository;
import ru.dawgg.bookmarket.service.BookService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.dawgg.bookmarket.exception.ApiEntityNotFoundException.BOOK_NOT_FOUND_EXCEPTION;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<BookDto> findAll() {
        List<Book> books = (List<Book>) repository.findAll();
        return books.stream()
                .map(book -> mapper.map(book, BookDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto findOne(Long id) {
        BookDto book = mapper.map(repository.findById(id), BookDto.class);

        return Optional.ofNullable(book)
                .orElseThrow(new ApiEntityNotFoundException(BOOK_NOT_FOUND_EXCEPTION, id));
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