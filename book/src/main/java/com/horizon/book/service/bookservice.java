package com.horizon.book.service;

import com.horizon.book.entity.book;

import java.util.List;
import java.util.Optional;

public interface bookservice {
    List<book> getAllBooks();
    book add(book b);
    Optional<book> findById(Long id);
    void delete(Long id);
    book update(book b);
}
