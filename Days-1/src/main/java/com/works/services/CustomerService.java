package com.works.services;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import com.works.utils.REnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;

    public ResponseEntity save(Customer customer) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        try {
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

}
