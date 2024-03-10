package ru.dawgg.bookmarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.dawgg.bookmarket.dto.BookDto;
import ru.dawgg.bookmarket.model.BookGenre;
import ru.dawgg.bookmarket.service.BookService;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
@Validated
public class BookController {

    private final BookService service;

    @GetMapping
    public List<BookDto> showAllBooks() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public BookDto showTheBook(@PathVariable @NotNull Long id) {
        return service.findOne(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNewBook(@RequestBody @Valid BookDto bookDto) {
        service.save(bookDto);
        return new ResponseEntity<>(CREATED);
    }

    @GetMapping("/releasedAfter")
    public List<BookDto> getBooksReleasedAfterTheDate(@RequestBody @NotBlank LocalDate date) {
        return service.findAllReleasedAfter(date);
    }

    @GetMapping("/releasedBefore")
    public List<BookDto> getBooksReleasedBeforeTheDate(@RequestBody @NotBlank LocalDate date) {
        return service.findAllReleasedBefore(date);
    }

    @GetMapping("/cheapAtFirst")
    public List<BookDto> getSortedByPriceUpBooks() {
        return service.sortBooksByPrice();
    }

    @GetMapping("/expensiveAtFirst")
    public List<BookDto> getSortedByPriceDownBooks() {
        return service.sortBooksByPriceReversed();
    }

    @GetMapping("/newAtFirst")
    public List<BookDto> sortBooksFromNewToOld() {
        return service.sortBooksByReleaseDateReversed();
    }

    @GetMapping("/oldAtFirst")
    public List<BookDto> sortBooksFromOldToNew() {
        return service.sortBooksByReleaseDate();
    }

    @GetMapping("/genre/{genre}")
    public List<BookDto> showBooksOfTheGenre(@PathVariable @NotBlank BookGenre genre) {
        return service.filterBooksByGenre(genre);
    }
}