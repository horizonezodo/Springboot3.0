package com.horizon.book.controll;

import com.horizon.book.entity.book;
import com.horizon.book.service.bookservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class bookcontroller {

    private final bookservice service;

    @GetMapping("/all")
    public ResponseEntity<List<book>> getAllBooks(){
        return ResponseEntity.ok(service.getAllBooks());
    }

    @GetMapping("/book/{id}")
    public Optional<book> getById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<book> add(@RequestBody book theBook){
        return new ResponseEntity<>(service.add(theBook), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<book> update(@RequestBody book theBook) {
        return  new ResponseEntity<>(service.update(theBook), HttpStatus.OK);
    }

    @DeleteMapping("/book/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
