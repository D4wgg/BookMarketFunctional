package ru.dawgg.bookmarket.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dawgg.bookmarket.model.Author;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Книга")
public class BookDto {
    @NotEmpty(message = "Book name can not be empty")
    @Schema(name = "название книги")
    private String name;

    @NotEmpty(message = "Every book should have a genre")
    @Schema(name = "Жанр книги")
    private String genre;

    @NotEmpty(message = "when was the book published?")
    @Schema(name = "Дата релиза книги")
    private LocalDate releaseDate;

    @NotEmpty(message = "Book can not be written by itself")
    @Schema(name = "Автор книги")
    private Author author;
}
