package com.horizon.book.repositorr;

import com.horizon.book.entity.book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookrepository extends JpaRepository<book, Long> {
}
