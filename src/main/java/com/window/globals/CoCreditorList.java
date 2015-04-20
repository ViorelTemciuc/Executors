package com.window.globals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.CoCreditorService;


@Component
public class CoCreditorList {
	
	@Autowired
	private CoCreditorService coCreditorService;
  
	public List<?> getListByIncheiereId(int incId){
		return coCreditorService.getAllCoCreditorsByIncheiere(incId);
		
	}

	
}
