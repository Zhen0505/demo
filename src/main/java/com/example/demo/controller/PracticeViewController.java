package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.TransferDto;
import com.example.demo.entity.Practice;
import com.example.demo.service.PracticeService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/practice")
@Slf4j
public class PracticeViewController {
	
	@Autowired
	PracticeService practiceS;
	
	@RequestMapping(value = "/index")
	public String index(Map<String, Object> model) {
		log.info("Practice controller");
		return "test";
	}
	
	@GetMapping(value = "/register")
	public String registerView() {
		return "register";
	}
	
	@PostMapping(value = "/register")
	public String register(@ModelAttribute("registerform") Practice formdata,
			Map<String, Object> model) {
		log.info("{}", formdata);
		Practice register =practiceS.register(formdata);
		if(register!=null) {
			model.put("result", "註冊成功");
		}
		else {
			model.put("result", "註冊失敗,帳號已存在");
		}
		return "resultP";
	}
	
	@RequestMapping(value = "/result")
	public String resultR() {
		return "test";
	}
	
	@GetMapping(value = "/login")
	public String loginView() {
		return "login";
	}
	
	@PostMapping(value = "/login")
	public String login(@ModelAttribute("loginform") Practice formdata,
			Map<String, Object> model) {
		log.info("{}", formdata);
		Practice login =practiceS.login(formdata);
		if(login!=null) {
			model.put("id", login.getId());
			model.put("name", login.getName());
			model.put("price", login.getPrice());
			return "home";
		}
		else {
			model.put("result", "帳號不存在或密碼錯誤，請重新登入");
			return "resultP";
		}
	}
	
	@PostMapping(value = "/transfer")
	public String transfer(@ModelAttribute("transferform") TransferDto formdata,
			Map<String, Object> model) {
		log.info("{}", formdata);
		model.put("fromid", formdata.getFromid());
		model.put("toid", formdata.getToid());
		model.put("money", formdata.getMoney());
		return "transfer";
	}
	
	@PostMapping(value = "/check")
	public String check(@ModelAttribute("check") TransferDto formdata,
			Map<String, Object> model) {
		log.info("{}", formdata);
		Practice result=practiceS.transfer(formdata);
		if(result!=null) {
			model.put("result","交易成功");
			model.put("balance", result.getPrice());
			return "resultP";
		}
		else {
			model.put("result","交易失敗");
			return "resultP";
		}
	}
}
