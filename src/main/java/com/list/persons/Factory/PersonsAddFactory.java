package com.list.persons.Factory;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.Persons;
import com.service.CoCreditorService;
import com.service.CoDebtorService;
import com.service.CreditorRepresentyService;
import com.service.DebtorRepresentyService;
import com.service.IncheiereService;
import com.service.PersonsService;
import com.service.SolidarCreditorService;
import com.service.SolidarDebtorService;


@Component
public class PersonsAddFactory {
	
	@Autowired
	private  PersonsService personsService;
	
	@Autowired
	private  SolidarDebtorService solidarDebtorService;
		
	@Autowired
	private  CoDebtorService coDebtorService;
	
	@Autowired
	private  SolidarCreditorService solidarCreditorService;
	
	@Autowired
	private  CoCreditorService coCreditorService;
	
	@Autowired
	private  DebtorRepresentyService debtorRepresentyService;
	
	@Autowired
	private  CreditorRepresentyService creditorRepresentyService;
	
	@Autowired
	private IncheiereService incheiereService;
	
	@Autowired
	private PersonsListFactory personsListFactory;
	
	@SuppressWarnings("incomplete-switch")
	public  Map<String,List<?>> addCorePersons(String typ,int incheiere_id,Persons person)throws Exception{
		PersonsListType type=PersonsListType.valueOf(typ);
		switch (type) {
		case SolidarDebtor:
			solidarDebtorService.addPerson(person, incheiereService.getIncheiereById(incheiere_id));	
			break;
		case CoDebtor: coDebtorService.addPerson(person,incheiereService.getIncheiereById(incheiere_id));	
			break;
		case SolidarCreditor: solidarCreditorService.addPerson(person,incheiereService.getIncheiereById(incheiere_id));	
			break;
		case CoCreditor: coCreditorService.addPerson(person,incheiereService.getIncheiereById(incheiere_id));
			break;
		case RepresentyCreditorr: creditorRepresentyService.addPerson(person, incheiereService.getIncheiereById(incheiere_id));
			break;
		case RepresentyDebtorr: debtorRepresentyService.addPerson(person, incheiereService.getIncheiereById(incheiere_id));
			break;
		}
		String[] typeArray = typ.split("(?=[A-Z])");
		typ=typeArray[typeArray.length-1];//Debtor
		return personsListFactory.getCorePersons(typ, incheiere_id);
				
	}
	@SuppressWarnings("incomplete-switch")
	public  Map<String,List<?>> updateCorePersons(String typ,int incheiere_id,Persons person){
		PersonsListType type=PersonsListType.valueOf(typ);
		switch (type) {
		case SolidarDebtor:
			solidarDebtorService.updatePersons(person, incheiereService.getIncheiereById(incheiere_id));	
			break;
		case CoDebtor: coDebtorService.updatePersons(person, incheiereService.getIncheiereById(incheiere_id));	
			break;
		case SolidarCreditor: solidarCreditorService.updatePersons(person, incheiereService.getIncheiereById(incheiere_id));
			break;
		case CoCreditor: coCreditorService.updatePersons(person, incheiereService.getIncheiereById(incheiere_id));
			break;
		}
		String[] typeArray = typ.split("(?=[A-Z])");
		typ=typeArray[typeArray.length-1];
		return personsListFactory.getCorePersons(typ, incheiere_id);
				
	}
	
	public  Map<String,List<?>> deleteCorePersons(String typ,int incheiere_id,Persons person,boolean all){
		
		
			 all = solidarDebtorService.deletePersons(person, incheiereService.getIncheiereById(incheiere_id));	
		     all = coDebtorService.deletePersons(person, incheiereService.getIncheiereById(incheiere_id));
			 all = solidarCreditorService.deletePersons(person, incheiereService.getIncheiereById(incheiere_id));
			 all = coCreditorService.deletePersons(person, incheiereService.getIncheiereById(incheiere_id));
			
		if(all){
			personsService.deletePersons(person);
		}
		String[] typeArray = typ.split("(?=[A-Z])");
		typ=typeArray[typeArray.length-1];
		return personsListFactory.getCorePersons(typ, incheiere_id);
				
	}
	

}
