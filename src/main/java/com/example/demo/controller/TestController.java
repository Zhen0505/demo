package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Test;
import com.example.demo.service.TestService;

@RestController
@RequestMapping("api/test")
public class TestController {
	
	@Autowired
	private TestService testS;
	
	@GetMapping(value = "/hello")
	public String HelloWorld() {
		return "Hello World";
	}
	
	@GetMapping(value = "/testlist")
	public List<Test> getTestList() {
		return testS.getTestList();
	}
	
	@PostMapping(value = "/insertTest")
	public Test insertTest(@RequestBody Test rq) {
		return testS.insertTest(rq);
	}
	
	@RequestMapping("/updateTest")
	public Test updateTest(@RequestParam Integer id, @RequestBody Test nw) {
	    nw.setId(id);  
	    return testS.updateTest(nw);
	}
	
	@DeleteMapping(value = "/deleteTest")
	public List<Test> deleteTest(@RequestParam Integer id) {
		return testS.deleteTest(id);
	}
	
	//登入
	@PostMapping(value="/login")
	public Test login(@RequestBody Test rq){
		return testS.Login(rq);
	}
	
	
	
}
