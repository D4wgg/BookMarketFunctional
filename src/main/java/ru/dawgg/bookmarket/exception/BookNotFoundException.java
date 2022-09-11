package ru.dawgg.bookmarket.exception;

public class BookNotFoundException extends Exception {
    private static final String MESSAGE = "Book has not been found";

    public BookNotFoundException() {
        super(MESSAGE);
    }

    public BookNotFoundException(Long id) {
        super(MESSAGE + " by the id - " + id);
    }
}
