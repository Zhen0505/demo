package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "Practice")
@Entity
public class Practice {
	@Id
	public int id;
	
	public String password;
	
	public int price;
}
