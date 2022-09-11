package ru.dawgg.bookmarket.exception;

public class AuthorNotFoundException extends Exception {
    private static final String MESSAGE = "Author has not been found";

    public AuthorNotFoundException() {
        super(MESSAGE);
    }

    public AuthorNotFoundException(Long id) {
        super(MESSAGE + " by id - " + id);
    }
}
