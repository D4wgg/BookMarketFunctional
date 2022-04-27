package ru.dawgg.bookmarket.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Автор книги")
public class AuthorDto {
    @NotEmpty(message = "Author should have a name")
    @Schema(name = "Имя автора")
    private String name;

    @NotEmpty(message = "Author should have a surname")
    @Schema(name = "Фамилия автора")
    private String surname;

    @NotEmpty(message = "Has the author been always existed?")
    @Schema(name = "Дата рождения автора")
    private LocalDate birthDate;

    @NotEmpty(message = "The person who has not written any book is not an author")
    @Schema(name = "Книги, написанные этим автором")
    private List<BookDto> books;
}
