package com.horizon.book.controll;

import com.horizon.book.entity.user;
import com.horizon.book.entity.userRecord;
import com.horizon.book.service.userservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class usercontroll {

    private final userservice service;

    @GetMapping("/all")
    public ResponseEntity<List<userRecord>> getAllUsers(){
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<user> addUser(@RequestBody user u){
        return ResponseEntity.ok(service.add(u));
    }

    @GetMapping("/{email}")
    public user getByEmail(@PathVariable("email") String email){
        return service.getUser(email);
    }

    @DeleteMapping("/{email}")
    public void deleteUser(@PathVariable("email") String email){
        service.delete(email);
    }

    @PutMapping("/update")
    public ResponseEntity<user> update(@RequestBody user u){
        return ResponseEntity.ok(service.update(u));
    }
}
