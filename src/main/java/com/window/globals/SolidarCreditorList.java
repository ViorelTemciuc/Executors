package com.window.globals;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.SolidarCreditorService;

@Component
public class SolidarCreditorList {

	@Autowired
	private SolidarCreditorService solidarCreditorService;
	
    
	 public List<?> getListByIncheiereId(int incId){
		 return solidarCreditorService.getAllSolidarCreditorsByIncheiere(incId);
	 }
	
	
}
