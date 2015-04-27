package com.window.globals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.DebtorRepresentyService;


@Component
public class DebtorRepresentyList {

	@Autowired
	private DebtorRepresentyService debtorRepresentyService;

	 public List<?> getListByIncheiereId(int incId){
		 return debtorRepresentyService.getAllDebtorRepresentysByIncheiere(incId);
	 }
	
	
}
