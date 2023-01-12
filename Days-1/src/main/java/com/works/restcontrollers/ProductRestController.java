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
    public ResponseEntity list(@RequestParam(defaultValue = "0") int page) {
        return service.list(page);
    }

    @GetMapping("/allList")
    public ResponseEntity allList(@RequestParam(defaultValue = "0") int page) {
        return service.allList(page);
    }

    @GetMapping("/products")
    public ResponseEntity products() {
        return service.products();
    }

}
