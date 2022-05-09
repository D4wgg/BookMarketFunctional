package ru.dawgg.bookmarket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Книга")
public class BookDto {
    @NotEmpty(message = "Book name can not be empty")
    @JsonProperty(value = "название книги")
    private String name;

    @NotEmpty(message = "Every book should have a genre")
    @JsonProperty(value = "Жанр книги")
    private String genre;

    @NotEmpty(message = "Every book should have a price")
    @JsonProperty(value = "Стоимость книги")
    private BigDecimal price;

    @NotEmpty(message = "when was the book published?")
    @JsonProperty(value = "Дата релиза книги")
    private LocalDate releaseDate;

    @NotEmpty(message = "Book can not be written by itself")
    @JsonProperty(value = "Имя автора")
    private String authorName;

    @NotEmpty(message = "Book can not be written by itself")
    @JsonProperty(value = "Фамилия автора")
    private String authorSurname;
}
