package ru.dawgg.bookmarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dawgg.bookmarket.dto.AuthorDto;
import ru.dawgg.bookmarket.dto.BookDto;
import ru.dawgg.bookmarket.service.AuthorService;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authors")
@Validated
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public List<AuthorDto> getAllAuthors() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public AuthorDto getAnAuthorById(@PathVariable @NotNull Long id) {
        return authorService.findOneById(id);
    }

    @GetMapping("/{id}/books")
    public List<BookDto> getAllBooksWrittenByTheAuthor(@PathVariable @NotNull Long id) {
        return authorService.findOneById(id).getBooks();
    }

    @GetMapping("/{name}")
    public List<AuthorDto> getAllByName(@PathVariable @NotBlank String name) {
        return authorService.findAllByName(name);
    }
}
