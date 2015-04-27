package com.window.globals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.CreditorRepresentyService;

@Component
public class CreditorRepresentyList {

	@Autowired
	private CreditorRepresentyService creditorRepresentyService;

	 public List<?> getListByIncheiereId(int incId){
		 return creditorRepresentyService.getAllCreditorRepresentysByIncheiere(incId);
	 }
	
	
}
