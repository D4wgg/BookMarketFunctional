package ru.dawgg.bookmarket.service;

import ru.dawgg.bookmarket.dto.BookDto;
import ru.dawgg.bookmarket.model.characteristic.BookGenre;

import java.util.List;

public interface BookService {

    List<BookDto> findAll();

    BookDto findOne(Long id);

    List<BookDto> sortBooksByPrice();

    List<BookDto> sortBooksByPriceReversed();

    List<BookDto> filterBooksByGenre(BookGenre genre);

    List<BookDto> sortBooksByReleaseDate();

    List<BookDto> sortBooksByReleaseDateReversed();
}