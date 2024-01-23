package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PracticeRepository;
import com.example.demo.dto.TransferDto;
import com.example.demo.entity.Practice;

import jakarta.transaction.Transactional;

@Service
public class PracticeService {

	@Autowired
	private PracticeRepository practiceR;
	
	public Practice register(Practice rg) {
		Integer rid=rg.getId();
		Optional<Practice> oid=practiceR.findById(rid);
		if(oid.isEmpty()) {
			return practiceR.save(rg);
		}
		else {
			return null;
		}
	}
	
	public Practice login(Practice lg) {
		Integer lig=lg.getId();
		String lpw=lg.getPassword();
		Practice practice=practiceR.findByIdAndPassword(lig, lpw);
		if(practice!=null) {
			return practice;
		}
		else {
			return null;
		}
	}
	
	public List<Practice> getPList(){
		return practiceR.findAll();
	}
	
	@Transactional
	public Practice transfer(TransferDto tf) {
		
		Integer fromId=tf.getFromid();
		Integer toId=tf.getToid();
		Integer money=tf.getMoney();
		
		Optional<Practice> fid=practiceR.findById(fromId);
		Optional<Practice> tid=practiceR.findById(toId);
		
		if(fid.isPresent()&&tid.isPresent()) {
			
			Practice fromAccoount=fid.get();
			Practice toAccoount=tid.get();
			
			// Decrease money from fromAccount
			fromAccoount.setPrice(fromAccoount.getPrice() - money);
	        practiceR.save(fromAccoount);

	        // Add money to toAccount
	        toAccoount.setPrice(toAccoount.getPrice() + money);
	        practiceR.save(toAccoount);
	        
	        return fromAccoount;
		}
		else {
			return null;
		}
	}
}
