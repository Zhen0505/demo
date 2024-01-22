package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Test;
import com.example.demo.service.TestService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/example")
@Slf4j
public class TestViewController {
	
	@Autowired
	private TestService testS;
	private String message = "Pages";
	
	@RequestMapping("/test")
	public String index(Map<String, Object> model) {
		this.message="輸入⾴";
		model.put("dataList", testS.getTestList());
		model.put("message", this.message);
		return "test2";
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute("testform") Test formData,Map<String, Object> model) {
		log.info("{}",formData);
		Test check = testS.updateTest(formData);
		
		if (check == null) {
			model.put("update", "查無此帳號，修改失敗");
		}
		else
			model.put("update", "修改成功");
		
		return "result";
		
	}
	
	@RequestMapping("/delete")
	 public String delete(@RequestParam Integer id, Map<String, Object> model) {
		String result=testS.deleteTest2(id);
	    model.put("delete", result);
	    return "result";
	 }
	
	@RequestMapping("/confirm")
	public String confirm(@ModelAttribute("testform") Test formData,Map<String, Object> model) {
		this.message="確認⾴";
		log.info("{}",formData);
		model.put("id", formData.getId());
		model.put("name", formData.getName());
		return "confirm";
	}
	
	@RequestMapping("/result")
	public String result(@ModelAttribute("testform") Test formData,Map<String, Object> model) {
		log.info("{}",formData);
		Test result = testS.insertTest(formData);
		
		if (result == null) {
			model.put("result", "新增失敗");
		}
		else
			model.put("result", "新增成功");
		
		return "result";
		
	}
}
