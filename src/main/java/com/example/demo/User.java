package com.example.demo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
}
