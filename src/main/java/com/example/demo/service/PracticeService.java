package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PracticeRepository;
import com.example.demo.entity.Practice;

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
}
