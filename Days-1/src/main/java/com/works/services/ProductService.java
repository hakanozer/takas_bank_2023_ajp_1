package com.works.services;

import com.works.configs.AppBeans;
import com.works.entities.Customer;
import com.works.entities.Product;
import com.works.props.ProductData;
import com.works.repositories.JoinProCustRepository;
import com.works.repositories.ProductRepository;
import com.works.utils.REnum;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository repository;
    final AppBeans appBeans;
    final JoinProCustRepository joinProCustRepository;
    final CacheManager cacheManager;
    final RestTemplate restTemplate;

    public ResponseEntity save(Product product) {
        product.setCid( appBeans.customer().getCid() );
        repository.save(product);
        Map<REnum, Object> hm = new LinkedHashMap<>();
        hm.put(REnum.status, true);
        hm.put(REnum.result, product);
        cacheManager.getCache("product").clear();
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list(int page) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        hm.put(REnum.status, true);
        long cid = appBeans.customer().getCid();
        //hm.put(REnum.result, joinProCustRepository.joinFindAll(cid) );
        Sort sort = Sort.by(Sort.Order.asc("price"));
        Pageable pageable = PageRequest.of(page, 5, sort );
        hm.put(REnum.result, repository.joinFindAll(cid, pageable) );
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    @Cacheable("product")
    public ResponseEntity allList(int page) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        hm.put(REnum.status, true);
        Sort sort = Sort.by(Sort.Order.asc("price"));
        Pageable pageable = PageRequest.of(page, 5, sort );
        hm.put(REnum.result, repository.findAll(pageable) );
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity products() {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        String url = "https://dummyjson.com/products";
        ProductData proData = restTemplate.getForObject(url, ProductData.class);
        proData.getProducts().get(0).setPrice(1111);
        hm.put(REnum.status, true);
        hm.put(REnum.result, proData);
        return new ResponseEntity(hm, HttpStatus.OK);
    }


}
