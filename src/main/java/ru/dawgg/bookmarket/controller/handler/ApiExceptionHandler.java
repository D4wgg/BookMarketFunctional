package ru.dawgg.bookmarket.controller.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.dawgg.bookmarket.exception.AuthorNotFoundException;
import ru.dawgg.bookmarket.exception.BookNotFoundException;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    protected ResponseEntity<ErrorMessage> bookNotFoundExceptionHandler(BookNotFoundException ex) {
        return commonMessage(ex, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    protected ResponseEntity<ErrorMessage> authorNotFoundExceptionHandler(AuthorNotFoundException ex) {
        return commonMessage(ex, HttpStatus.NOT_ACCEPTABLE);
    }

    private ResponseEntity<ErrorMessage> commonMessage(Exception ex, HttpStatus httpStatus) {
        var message = ex.getMessage();
        log.error(message, ex);
        return new ResponseEntity<>(
                ErrorMessage.builder()
                        .message(message)
                        .stackTrace(ExceptionUtils.getStackTrace(ex))
                        .build(),
                httpStatus
        );
    }
}
