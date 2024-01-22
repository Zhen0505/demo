package com.example.demo.controller;

import java.util.List;
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
public class TestView {
	
	@Autowired
	TestService testS;
	
	private String message="Pages";
	
	@RequestMapping("/test")
	public String index(Map<String, Object> model) {
		log.info("TEST controller");
		this.message="輸入頁";
		List<Test> tmpList=testS.getTestList();
		log.info("{}",tmpList);
		model.put("datalist", tmpList);
		model.put("message", this.message);
		return "test2";
	}
	@RequestMapping("/create")
	public String confirm(@ModelAttribute("testform") Test formData,
			Map<String, Object> model) {
		log.info("{}",formData);
		model.put("id", formData.getId());
		model.put("name", formData.getName());
		return "confirm";
	}
	
	@RequestMapping("/result")
	public String result(@ModelAttribute("testform") Test formData,
			Map<String, Object> model) {
		log.info("{}",formData);
		Test result=testS.insertTest(formData);
		if(result==null) {
			model.put("result", "新增失敗,帳號已存在");
		}
		else {
			model.put("result", "新增成功");
		}
		return "result";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id,
			Map<String, Integer> model) {
		model.put("id", id);
		return "confirm2";
	}
	
	@RequestMapping("/check")
	public String check(@ModelAttribute("id") Integer id ,
			Map<String, Object> model) {
		log.info("{}",id);
		String result=testS.deleteTest2(id);
		  model.put("result", result);
		return "result";
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute("updateform") Test formData,
			Map<String, Object> model) {
		log.info("{}",formData);
		model.put("uid", formData.getId());
		model.put("uname", formData.getName());
		return "confirm";
	}
	
	@RequestMapping("/result2")
	public String updateresult(@ModelAttribute("updateform") Test formData,
			Map<String, Object> model) {
		log.info("{}",formData);
		Integer id=formData.getId();
		Test result=testS.updateTest(id,formData);
		if(result==null) {
			model.put("result", "編輯失敗,帳號不存在");
		}
		else {
			model.put("result", "編輯成功");
		}
		return "result";
	}

}
