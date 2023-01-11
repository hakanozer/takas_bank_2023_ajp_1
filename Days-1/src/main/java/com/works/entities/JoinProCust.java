package com.works.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class JoinProCust {

    @Id
    @GeneratedValue
    private Long pid;

    private Long cid;
    private String title;
    private Integer price;
    private String name;
    private String email;


}
