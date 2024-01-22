package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="Example")
@Entity
public class Example {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private int fromaccountid;
	private int toaccountid;
	private int account;
    private String name;
    private int money;
    
    public int getMoney() {
        return this.money;
    }

}
