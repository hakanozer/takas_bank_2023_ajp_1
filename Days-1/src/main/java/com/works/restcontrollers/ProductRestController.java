package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductRestController {

    final ProductService service;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product ) {
        return service.save(product);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return service.list();
    }

}
