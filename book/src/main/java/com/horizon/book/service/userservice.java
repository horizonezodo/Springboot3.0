package com.horizon.book.service;

import com.horizon.book.entity.user;
import com.horizon.book.entity.userRecord;

import java.util.List;

public interface userservice {
    user add(user u);
    List<userRecord> getAllUsers();
    void delete(String email);
    user getUser(String email);
    user update(user u);
}
