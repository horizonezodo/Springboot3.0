package com.horizon.book.service.Impl;

import com.horizon.book.entity.user;
import com.horizon.book.entity.userRecord;
import com.horizon.book.repositorr.userrepository;
import com.horizon.book.service.userservice;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class userServiceImpl implements userservice {
    private final userrepository repo;
    private final PasswordEncoder encoder;
    @Override
    public user add(user u) {
        Optional<user> theUser = repo.findByEmail(u.getEmail());
        if(theUser.isPresent()){
            throw new RuntimeException("A user with " + u.getEmail() + " has been used");
        }
        u.setPassword(encoder.encode(u.getPassword()));
        return repo.save(u);
    }

    @Override
    public List<userRecord> getAllUsers() {
        return repo.findAll()
                .stream()
                .map(user -> new userRecord(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail()
                )).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(String email) {
        repo.deleteByEmail(email);
    }

    @Override
    public user getUser(String email) {
        return repo.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public user update(user u) {
        u.setRoles(u.getRoles());
        return repo.save(u);
    }
}
