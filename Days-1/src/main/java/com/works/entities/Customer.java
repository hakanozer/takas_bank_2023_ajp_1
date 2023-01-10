package com.works.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long cid;

    @Length(min = 2, max = 100)
    @NotEmpty
    @NotNull
    @Column(length = 100)
    private String name;

    @Max(90)
    @Min(18)
    private Integer age;

    @NotEmpty
    @Email
    @NotNull
    @Column(unique = true, length = 200)
    private String email;


    @Length(min = 5)
    @NotEmpty
    @NotNull
    @Column(length = 500)
    private String password;

}
