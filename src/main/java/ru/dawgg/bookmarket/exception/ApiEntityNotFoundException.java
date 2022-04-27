package ru.dawgg.bookmarket.exception;

public class ApiEntityNotFoundException extends InnerApiException {

    public static final String BOOK_NOT_FOUND_EXCEPTION = "Book is not found";
    public static final String AUTHOR_NOT_FOUND_EXCEPTION = "Author is not found";

    public ApiEntityNotFoundException(String message) {
        super(message + "! The properties are wrong, recheck it carefully");
    }

    public ApiEntityNotFoundException(String message , Long id) {
        super(message + " id: " + id);
    }
}
