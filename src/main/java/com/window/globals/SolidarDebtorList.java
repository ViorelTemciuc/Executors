package com.window.globals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.SolidarDebtorService;

@Component
public class SolidarDebtorList {

	@Autowired
	private SolidarDebtorService solidarDebtorService;

	 public List<?> getListByIncheiereId(int incId){
		 return solidarDebtorService.getAllSolidarDebtorsByIncheiere(incId);
	 }
	
	
}
