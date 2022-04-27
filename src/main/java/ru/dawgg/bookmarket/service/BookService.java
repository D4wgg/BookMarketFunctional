package ru.dawgg.bookmarket.service;

import ru.dawgg.bookmarket.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> findAll();

    BookDto findOne(Long id);
}