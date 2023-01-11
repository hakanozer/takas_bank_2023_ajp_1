package com.works.restcontrollers;

import com.works.entities.Customer;
import com.works.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerRestController {

    final CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody Customer customer) {
        return customerService.login(customer);
    }

    @GetMapping("/product")
    public Object product() {
        Map hm = new HashMap();
        hm.put("product", "All Prod");
        return hm;
    }

}
