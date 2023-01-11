package com.works.repositories;

import com.works.entities.JoinProCust;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinProCustRepository extends JpaRepository<JoinProCust, Long> {

    @Query(value = "SELECT p.pid, c.cid ,p.title, p.price, c.name, c.email  FROM PRODUCT as p inner join customer as c on p.cid = c.cid where p.cid = ?1", nativeQuery = true)
    List<JoinProCust> joinFindAll(long cid);

}