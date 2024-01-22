package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Test;

public interface TestRepository extends JpaRepository<Test, Integer>{

	Test findByIdAndName(Integer id,String name);
}
