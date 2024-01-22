package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="Test")
@Entity
public class Test {

    @Id
    private int id;
    private String name;
}