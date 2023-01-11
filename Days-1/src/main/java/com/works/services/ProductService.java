package com.works.services;

import com.works.configs.AppBeans;
import com.works.entities.Customer;
import com.works.entities.Product;
import com.works.repositories.JoinProCustRepository;
import com.works.repositories.ProductRepository;
import com.works.utils.REnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository repository;
    final AppBeans appBeans;
    final JoinProCustRepository joinProCustRepository;

    public ResponseEntity save(Product product) {
        product.setCid( appBeans.customer().getCid() );
        repository.save(product);
        Map<REnum, Object> hm = new LinkedHashMap<>();
        hm.put(REnum.status, true);
        hm.put(REnum.result, product);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list() {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        hm.put(REnum.status, true);
        long cid = appBeans.customer().getCid();
        //hm.put(REnum.result, joinProCustRepository.joinFindAll(cid) );
        hm.put(REnum.result, repository.joinFindAll(cid) );
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
