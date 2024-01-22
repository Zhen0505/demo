package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.TestRepository;
import com.example.demo.entity.Test;


@Service
public class TestService {

	@Autowired
	private TestRepository testR;
	
	public List<Test> getTestList(){
		return testR.findAll();
	}
	
	public Test insertTest(Test param) {
		Integer aid=param.getId();
		Optional<Test> tid = testR.findById(aid);
		if (tid.isPresent()) {
			return null;
        } else {
            return testR.save(param);
        }
		
	}
	
	public String updateTest2(Integer id, Test up) {
		Optional<Test> tid = testR.findById(id);
		
        if (tid.isPresent()) {
        	up.setId(id);
        	testR.save(up);
	        return "更新成功";
        } else {
            return "更新失敗";
        }
	}
	
	public Test updateTest(Integer id, Test up) {
		Optional<Test> tid = testR.findById(id);
		
        if (tid.isPresent()) {
        	up.setId(id);
	        return testR.save(up);
        } else {
            return null;
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
			return null;
		}
	}
	
	@Transactional
	public String deleteTest2(Integer id) {
		Optional<Test> tid = testR.findById(id);
		try {
			if (tid.isPresent()) {
				testR.deleteById(id);
				return "刪除成功";
	        } else {
	            return "刪除失敗，不存在此帳號";
	        }
		}catch(Exception e) {
			e.printStackTrace();
//			log.error("{}",e.getMessage());
			return  "刪除失敗";
		}

	}
	
}
