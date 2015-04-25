package com.list.persons.Factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.CoCreditor;
import com.entities.CoDebtor;
import com.entities.Persons;
import com.entities.SolidarCreditor;
import com.entities.SolidarDebtor;
import com.service.CoCreditorService;
import com.service.CoDebtorService;
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
		case CoDebtor: coDebtorService.addPerson(new CoDebtor(person, incheiereService.getIncheiereById(incheiere_id)));	
			break;
		case SolidarCreditor: solidarCreditorService.addPerson(new SolidarCreditor(person, incheiereService.getIncheiereById(incheiere_id)));	
			break;
		case CoCreditor: coCreditorService.addPerson(new CoCreditor(person, incheiereService.getIncheiereById(incheiere_id)));
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
		case CoDebtor: coDebtorService.updatePersons(new CoDebtor(person, incheiereService.getIncheiereById(incheiere_id)));	
			break;
		case SolidarCreditor: solidarCreditorService.updatePersons(new SolidarCreditor(person, incheiereService.getIncheiereById(incheiere_id)));	
			break;
		case CoCreditor: coCreditorService.updatePersons(new CoCreditor(person, incheiereService.getIncheiereById(incheiere_id)));
			break;
		}
		String[] typeArray = typ.split("(?=[A-Z])");
		typ=typeArray[typeArray.length-1];
		return personsListFactory.getCorePersons(typ, incheiere_id);
				
	}
	@SuppressWarnings("incomplete-switch")
	public  Map<String,List<?>> deleteCorePersons(String typ,int incheiere_id,Persons person,boolean all){
		PersonsListType type=PersonsListType.valueOf(typ);
		switch (type) {
		case SolidarDebtor:
			 solidarDebtorService.deletePersons(person, incheiereService.getIncheiereById(incheiere_id));	
			break;
		case CoDebtor: coDebtorService.updatePersons(new CoDebtor(person, incheiereService.getIncheiereById(incheiere_id)));	
			break;
		case SolidarCreditor: solidarCreditorService.updatePersons(new SolidarCreditor(person, incheiereService.getIncheiereById(incheiere_id)));	
			break;
		case CoCreditor: coCreditorService.updatePersons(new CoCreditor(person, incheiereService.getIncheiereById(incheiere_id)));
			break;
		}
		if(all){
			personsService.deletePersons(person);
		}
		String[] typeArray = typ.split("(?=[A-Z])");
		typ=typeArray[typeArray.length-1];
		return personsListFactory.getCorePersons(typ, incheiere_id);
				
	}
	

}
