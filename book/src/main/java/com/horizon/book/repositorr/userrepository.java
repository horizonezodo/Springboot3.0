package com.horizon.book.repositorr;

import com.horizon.book.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userrepository extends JpaRepository<user,Long> {
    Optional<user> findByEmail(String email);
    void deleteByEmail(String email);
}
