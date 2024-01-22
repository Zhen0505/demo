package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "Test")
@Entity
public class Test {
	
	@Id
	public int id;
	
	public String name;

}
