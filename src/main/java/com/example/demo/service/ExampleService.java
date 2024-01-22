package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ExampleRepository;
import com.example.demo.entity.Example;

@Service
public class ExampleService {
	
	@Autowired
	private ExampleRepository examR;
	
	public List<Example> getExamList(){
		return examR.findAll();
	}
	public Example insertExam(Example param){
		Integer id=param.getId();
		Optional<Example> eid = examR.findById(id);
		if (eid.isEmpty()) {
			return examR.save(param);
		} else {
		    return null;
		}
	}
	public Example login(Example param) {
        Integer id = param.getId();
        String name = param.getName();
        Example result = examR.findByIdAndName(id, name);

        return result;
    }
	
	public Example findExampleByIdAndNameAndMoney(Integer id, String name, Integer money) {
        return examR.findByIdAndNameAndMoney(id, name, money).orElse(null);
    }
	
	public Integer getMoneyById(Integer id) {
        Optional<Example> exampleOptional = examR.findById(id);
        return exampleOptional.map(Example::getMoney).orElse(null);
    }
	
	@Transactional
	public Example decreaseMoney(Example decrease) {
	    Integer fromaccountid = decrease.getId();
	    Integer account = decrease.getMoney();
	    
	    Optional<Example> dm = examR.findById(fromaccountid);
	    
	    if (dm.isPresent()) {
	        Example decreaseExample = dm.get();
	        decreaseExample.setMoney(decreaseExample.getMoney() + account);
	        examR.save(decreaseExample);
	        return decreaseExample;
	    } else {
	        return null;
	    }
	}
	
	@Transactional
	public Example addMoney(Example add) {
	    Integer toaccountid = add.getId();
	    Integer account = add.getMoney();
	    
	    Optional<Example> am = examR.findById(toaccountid);
	    
	    if (am.isPresent()) {
	        Example addExample = am.get();
	        addExample.setMoney(addExample.getMoney() + account);
	        examR.save(addExample);
	        return addExample;
	    } else {
	        return null;
	    }
	}
	
	@Transactional
	public Example transfer(Example damoney) {
		Integer fromaccountid = damoney.getId();
		Integer toaccountid = damoney.getId();
		Integer account = damoney.getMoney();
	    Optional<Example> fromAccountOptional = examR.findById(fromaccountid);
	    Optional<Example> toAccountOptional = examR.findById(toaccountid);

	    if (fromAccountOptional.isPresent() && toAccountOptional.isPresent()) {
	        Example fromAccount = fromAccountOptional.get();
	        Example toAccount = toAccountOptional.get();

	        // Decrease money from fromAccount
	        fromAccount.setMoney(fromAccount.getMoney() - account);
	        examR.save(fromAccount);

	        // Add money to toAccount
	        toAccount.setMoney(toAccount.getMoney() + account);
	        examR.save(toAccount);

	        // You can return any relevant information here
	        return fromAccount;
	    } else {
	        return null;
	    }
	}

}
