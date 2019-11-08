package com.thomasvitale.application.service;

import com.thomasvitale.application.model.Book;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class BookService {

    private static Map<String, Book> bookRepository = new ConcurrentHashMap<>();

    static {
        bookRepository.put("1", new Book("1", "Harry Potter"));
        bookRepository.put("2", new Book("2", "The Lord of The Rings"));
        bookRepository.put("3", new Book("3", "The Golden Compass"));
    }

    public List<Book> findAllBooks() {
        return new ArrayList<>(bookRepository.values());
    }

    public Book findBookById(String id) {
        return bookRepository.get(id);
    }
}
