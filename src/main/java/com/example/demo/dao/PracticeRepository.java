package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Practice;

public interface PracticeRepository extends JpaRepository<Practice,Integer> {

	Practice findByIdAndPassword(Integer id,String password);
}
