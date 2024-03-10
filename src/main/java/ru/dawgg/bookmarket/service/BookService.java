package ru.dawgg.bookmarket.service;

import ru.dawgg.bookmarket.dto.BookDto;
import ru.dawgg.bookmarket.model.BookGenre;

import java.time.LocalDate;
import java.util.List;

public interface BookService {

    List<BookDto> findAll();

    BookDto findOne(Long id);

    List<BookDto> sortBooksByPrice();

    List<BookDto> sortBooksByPriceReversed();

    List<BookDto> filterBooksByGenre(BookGenre genre);

    List<BookDto> sortBooksByReleaseDate();

    List<BookDto> sortBooksByReleaseDateReversed();

    void save(BookDto bookDto);

    List<BookDto> findAllReleasedAfter(LocalDate date);

    List<BookDto> findAllReleasedBefore(LocalDate date);
}