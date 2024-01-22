package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TestRepository;
import com.example.demo.entity.Test;

@Service
public class TestService {
	
	@Autowired
	private TestRepository testR;
	
	public List<Test> getTestList(){
		return testR.findAll();
	}
	
	public Test insertTest(Test param){
		Integer id=param.getId();
		Optional<Test> tid = testR.findById(id);
		if (tid.isPresent()) {
			return null;
		} else {
		    return testR.save(param);
		}
	}
	
	public Test updateTest(Test up) {
	    Optional<Test> existingData = testR.findById(up.getId());

	    if (existingData.isPresent()) {
	        up.setId(existingData.get().getId());
	        return testR.save(up);
	    } else {
	        System.out.println("Update failed. Test with ID " + up.getId() + " not found.");
	        return null;
	    }
	}
	
	public String deleteTest2(Integer id) {
		 Optional<Test> tid = testR.findById(id);
		 if (tid.isPresent()) {
			 testR.deleteById(id);
		     return "刪除成功";
		 } else {
		     return "刪除失敗，不存在此帳號";
		 }
	}
	
	public List<Test> deleteTest(Integer id) {
        // 執行刪除操作
        testR.deleteById(id);
        
        // 取得剩下的資料列表
        return testR.findAll();
    }
	
	public Test Login(Test param) {
		  Integer id=param.getId();
		  String name=param.getName();
		  
		  Test result= testR.findByIdAndName(id, name);
		  
		  if(result!=null) {
		   System.out.println("登入成功");
		   return result;
		  }
		  else {
			  System.out.println("帳號不存在");
			  return null;
		  }
	}
	
	
}
