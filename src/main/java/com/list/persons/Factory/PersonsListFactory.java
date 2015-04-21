package com.list.persons.Factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.window.globals.CoCreditorList;
import com.window.globals.CoDebtorList;
import com.window.globals.SolidarCreditorList;
import com.window.globals.SolidarDebtorList;

@Component
public class PersonsListFactory {
	
	@Autowired
	private  SolidarDebtorList solidarDebtorList;
	
	@Autowired
	private  CoDebtorList coDebtorList;
	
	@Autowired
	private  SolidarCreditorList solidarCreditorList;
	
	@Autowired
	private  CoCreditorList coCreditorList;
	
	@SuppressWarnings("incomplete-switch")
	public  Map<String,List<?>> getCorePersons(String typ,int incheiere_id){
		Map <String,List<?>> personsMap=new HashMap<String, List<?>>();
		PersonsListType type=PersonsListType.valueOf(typ);
		switch(type){
		case Debtor:
			personsMap.put("solidari", solidarDebtorList.getListByIncheiereId(incheiere_id));
			personsMap.put("co", coDebtorList.getListByIncheiereId(incheiere_id));
			break;
					
		case Creditor:
			personsMap.put("solidari", solidarCreditorList.getListByIncheiereId(incheiere_id));
			personsMap.put("co", coCreditorList.getListByIncheiereId(incheiere_id));
			break;
			
		}
		return personsMap;
				
	}
	
}
