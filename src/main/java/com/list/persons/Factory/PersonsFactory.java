package com.list.persons.Factory;

import java.util.List;

import com.entities.Persons;
import com.window.globals.AbstractCDClass;
import com.window.globals.CoCreditorList;
import com.window.globals.CoDebtorList;
import com.window.globals.SolidarCreditorList;
import com.window.globals.SolidarDebtorList;

public class PersonsFactory {
	
	public static void addCorePerson(PersonsType type,Persons p){
		AbstractCDClass person =null;
		switch(type){
		case SolidarDebtor:
			person=SolidarDebtorList.getInstance();
			person.addTor(p);
			break;
			
		case SolidarCreditor:
			person=SolidarCreditorList.getInstance();
			person.addTor(p);
			break;
			
		case CoDebtors:
			person=CoDebtorList.getInstance();
			person.addTor(p);
			break;
			
		case CoCreditors:
			person=CoCreditorList.getInstance();
			person.addTor(p);
		}
				
	}
	public static void editCorePerson(PersonsType type,Persons p, int index){
		AbstractCDClass person =null;
		switch(type){
		case SolidarDebtor:
			person=SolidarDebtorList.getInstance();
			person.editTor(p, index);
			break;
			
		case SolidarCreditor:
			person=SolidarCreditorList.getInstance();
			person.editTor(p, index);
			break;
			
		case CoDebtors:
			person=CoDebtorList.getInstance();
			person.editTor(p, index);
			break;
			
		case CoCreditors:
			person=CoCreditorList.getInstance();
			person.editTor(p, index);
		}
				
	}
	public static void deleteCorePerson(PersonsType type,Persons p){
		AbstractCDClass person =null;
		switch(type){
		case SolidarDebtor:
			person=SolidarDebtorList.getInstance();
			person.deleteTor(p);
			break;
			
		case SolidarCreditor:
			person=SolidarCreditorList.getInstance();
			person.deleteTor(p);
			break;
			
		case CoDebtors:
			person=CoDebtorList.getInstance();
			person.deleteTor(p);
			break;
			
		case CoCreditors:
			person=CoCreditorList.getInstance();
			person.deleteTor(p);
		}
				
	}
	public static List<Persons> getCorePersonsList(PersonsType type){
		AbstractCDClass person =null;
		List<Persons> personList =null;
		switch(type){
		case SolidarDebtor:
			person=SolidarDebtorList.getInstance();
			personList=person.getTor();
			break;
		case SolidarCreditor:
			person=SolidarCreditorList.getInstance();
			personList=person.getTor();
			break;
		case CoDebtors:
			person=CoDebtorList.getInstance();
			personList=person.getTor();
			break;
		case CoCreditors:
			person=CoCreditorList.getInstance();
			personList=person.getTor();
			break;
		}
		return personList;
		
	}
}
