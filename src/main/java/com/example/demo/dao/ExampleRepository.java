package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Example;

public interface ExampleRepository extends JpaRepository<Example, Integer> {

	Example findByIdAndName(Integer id,String name);
	
	Optional<Example> findByIdAndNameAndMoney(Integer id, String name, Integer money);
	
	Optional<Example> findById(int id);
	
	Optional<Example> findByMoney(int money);
	
	Example transfer(Integer fromAccountId, Integer toAccountId, Integer money);
	
	Example decreaseMoney(Integer fromaccountid, Integer account);

	Example addMoney(Integer toaccountid, Integer account);
}
