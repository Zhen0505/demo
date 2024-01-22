package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Example;
import com.example.demo.service.ExampleService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("api/example")
@Slf4j
public class ExampleController {
	
	@Autowired
	private ExampleService examS;
	private String message = "Pages";
	
	@GetMapping(value = "/examlist")
	public List<Example> getExamList() {
		return examS.getExamList();
	}
	
	@PostMapping(value = "/insertExam")
	public Example insertExam(@RequestBody Example rq) {
		return examS.insertExam(rq);
	}
	
	@RequestMapping("/exam")
	public String index(Map<String, Object> model) {
		this.message="主⾴";
		model.put("dataList", examS.getExamList());
		model.put("message", this.message);
		return "example";
	}
	
	@RequestMapping("/signup")
	public String indexsu(Map<String, Object> model) {
		this.message="註冊⾴";
		model.put("dataList", examS.getExamList());
		model.put("message", this.message);
		return "signup";
	}
	
	@RequestMapping("/exconfirm1")
	public String exconfirm1(@ModelAttribute("testform1") Example formData,Map<String, Object> model) {
		this.message="註冊確認⾴";
		log.info("{}",formData);
		Example signup = examS.insertExam(formData);
		model.put("id", formData.getId());
		model.put("name", formData.getName());
		return "exconfirm1";
	}
	
	@RequestMapping("/exconfirm2")
	public String exconfirm2(@ModelAttribute("testform2") Example formData, Map<String, Object> model) {
	    this.message = "登入確認⾴";
	    log.info("{}", formData);

	    model.put("id", formData.getId());
	    model.put("name", formData.getName());
	    Example result = examS.login(formData);
	    if (result != null) {
	        model.put("login", "登入成功");

	    } else {
	        model.put("login", "帳號不存在");
	    }
	    return "exconfirm2";
	}
	
	@PostMapping("/exresult")
    public String signup(@ModelAttribute("testform1") Example formData,Map<String, Object> model) {
		log.info("{}",formData);
		model.put("id", formData.getId());
	    model.put("name", formData.getName());

		Example check = examS.insertExam(formData);
		
		if (check == null) {
			model.put("signup", "此帳號已存在，註冊失敗");
		}
		else
			model.put("signup", "註冊成功");
		
		return "exresult";
		
	}
	
	//登入
	 @PostMapping("/login")
	 public String login(@ModelAttribute("testform2") Example formData, Map<String, Object> model) {
	     log.info("{}", formData);

	     Integer id = formData.getId();

	     // 调用 service 层方法查询相同 id 的 money
	     Integer money = examS.getMoneyById(id);

	     model.put("id", id);
	     model.put("name", formData.getName());
	     model.put("money", money);

	     return "login";
	 }
	 
	 @RequestMapping("/transfer")
	 public String transfer(@ModelAttribute("testform") Example formData, Map<String, Object> model) {
		this.message = "轉帳⾴";
		log.info("{}", formData);

		model.put("fromaccountid", formData.getId());
		model.put("toaccountid", formData.getId());
		model.put("account", formData.getMoney());
		return "transfer";
	 }	
	 
	 
	 @PostMapping("/transres")
	 public String transres(@ModelAttribute("testform2") Example formData, Map<String, Object> model) {
			this.message = "註冊結果⾴";
			log.info("{}", formData);
			// 调用Service的transfer方法
	         Example traresult = examS.transfer(formData);

	         // 可以根据result的情况返回不同的响应
	         if (traresult != null) {
	 		    model.put("transfer", "轉帳成功");

	 	    } else {
	 		    model.put("transfer", "轉帳失敗");
	 		}
	 	    return "transres";
	     
	 }
	 
	 @PostMapping("/transress")
	 public String transress(@ModelAttribute("testform") Example formData, Map<String, Object> model) {
			this.message = "轉帳結果⾴";
			log.info("{}", formData);
			// 调用Service的transfer方法
	         Example traresult = examS.transfer(formData);

	         // 可以根据result的情况返回不同的响应
	         if (traresult != null) {
	 		    model.put("transfer", "轉帳成功");

	 	    } else {
	 		    model.put("transfer", "轉帳失敗");
	 		}
	 	    return "transres";
	     
	 }
}
