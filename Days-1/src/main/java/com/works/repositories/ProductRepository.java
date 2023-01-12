package com.works.repositories;

import com.works.entities.JoinProCust;
import com.works.entities.Product;
import com.works.projections.CustomerProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCidEquals(Long cid);

    @Query(value = "SELECT p.pid, c.cid ,p.title, p.price, c.name, c.email  FROM PRODUCT as p inner join customer as c on p.cid = c.cid where p.cid = ?1", nativeQuery = true)
    Page<CustomerProduct> joinFindAll(long cid, Pageable pageable);

}