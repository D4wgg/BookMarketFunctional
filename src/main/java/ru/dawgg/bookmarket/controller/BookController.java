package ru.dawgg.bookmarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dawgg.bookmarket.dto.BookDto;
import ru.dawgg.bookmarket.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping
    public List<BookDto> showAllBooks() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public BookDto showTheBook(@PathVariable("id") Long id) {
        return service.findOne(id);
    }
}