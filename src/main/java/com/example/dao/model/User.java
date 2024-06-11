package com.example.dao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class User {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "f_name")
    String fName;

    @Column(name = "l_name")
    String lName;
}
