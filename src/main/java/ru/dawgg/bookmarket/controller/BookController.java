package ru.dawgg.bookmarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/add")
    public void addNewBook(@RequestBody BookDto bookDto) {
        System.out.println(bookDto);
    }
}