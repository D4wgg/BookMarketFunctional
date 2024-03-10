package ru.dawgg.bookmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class BookMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMarketApplication.class, args);
    }
}
