package ru.dawgg.bookmarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dawgg.bookmarket.dto.AuthorDto;
import ru.dawgg.bookmarket.dto.BookDto;
import ru.dawgg.bookmarket.service.AuthorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public List<AuthorDto> getAllAuthors() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public AuthorDto findAnAuthorById(@PathVariable("id") Long id) {
        return authorService.findOneById(id);
    }

    @GetMapping("/{id}/books")
    public List<BookDto> getAllBooksWrittenByTheAuthor(@PathVariable("id") Long id) {
        return authorService.findOneById(id).getBooks();
    }
}
