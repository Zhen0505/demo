package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Test;
import java.util.List;
import java.util.Optional;


public interface TestRepository extends JpaRepository<Test, Integer>{
	Test findByIdAndName(Integer id,String name);
	
	Optional<Test> findById(int id);
}
