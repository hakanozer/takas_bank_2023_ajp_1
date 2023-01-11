package com.works.services;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import com.works.utils.REnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;
    final TinkEncDec tinkEncDec;
    final HttpServletRequest request;

    public ResponseEntity save(Customer customer) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        try {
            String newsPass = tinkEncDec.encrypt(customer.getPassword());
            customer.setPassword(newsPass);
            customerRepository.save(customer);
            hm.put(REnum.status, true);
            hm.put(REnum.result, customer);
            return new ResponseEntity(hm, HttpStatus.OK);
        }catch (Exception ex) {
            hm.put(REnum.status, false);
            hm.put(REnum.errors, "EMAIL in use - Fail : " + customer.getEmail());
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity login(Customer customer) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        Optional<Customer> optionalCustomer = customerRepository.findByEmailEqualsIgnoreCase(customer.getEmail());
        if ( optionalCustomer.isPresent() ) {
            Customer c = optionalCustomer.get();
            String dbPass = tinkEncDec.decrypt(c.getPassword());
            if (customer.getPassword().equals(dbPass)) {
                hm.put(REnum.status, true);
                hm.put(REnum.result, c);
                request.getSession().setAttribute("user", c);
                return new ResponseEntity(hm, HttpStatus.OK);
            }
        }
        hm.put(REnum.status, false);
        hm.put(REnum.message, "Email or Password Fail");
        return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
    }


}
