package com.horizon.book.service.Impl;

import com.horizon.book.entity.book;
import com.horizon.book.repositorr.bookrepository;
import com.horizon.book.service.bookservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class bookServiceImpl implements bookservice {
    private final bookrepository repo;
    @Override
    public List<book> getAllBooks() {
        return repo.findAll();
    }

    @Override
    public book add(book b) {
        return repo.save(b);
    }

    @Override
    public Optional<book> findById(Long id) {
        return Optional.ofNullable(repo.findById(id).orElseThrow(() -> new RuntimeException("No book found with this id : " + id)));
    }

    @Override
    public void delete(Long id) {
        Optional<book> theBook = findById(id);
        theBook.ifPresent(book ->
             repo.deleteById(book.getId())
        );
    }

    @Override
    public book update(book b) {
        return repo.save(b);
    }
}
