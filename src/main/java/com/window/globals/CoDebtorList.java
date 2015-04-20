package com.window.globals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.CoDebtorService;

@Component
public class CoDebtorList {
	
	@Autowired
	private CoDebtorService coDebtorService;
  
	public List<?> getListByIncheiereId(int incId){
		return coDebtorService.getAllCoDebtorsByIncheiere(incId);
		
	}

	

	
}
