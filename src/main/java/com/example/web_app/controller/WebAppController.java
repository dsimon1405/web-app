package com.example.web_app.controller;

import com.example.web_app.product.Product;
import com.example.web_app.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/web-app")
@AllArgsConstructor
public class WebAppController {

    private ProductRepository repo;

    @GetMapping("/hello")
    public String getHello() {
        return "Hello app";
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
        Product prod = repo.findById(id).orElse(null);
        return prod == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND): new ResponseEntity<>(prod, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProd(@RequestBody Product prod) {
        return prod.getId() != null ?
                new ResponseEntity<Product>(HttpStatus.BAD_REQUEST)
                : new ResponseEntity<Product>(repo.save(prod), HttpStatus.OK);  //  can't add product with id
    }
}