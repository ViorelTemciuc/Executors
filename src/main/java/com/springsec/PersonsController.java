package com.springsec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entities.CoCreditor;
import com.entities.CoDebtor;
import com.entities.Persons;
import com.entities.SolidarCreditor;
import com.entities.SolidarDebtor;
import com.list.persons.Factory.PersonsFactory;
import com.list.persons.Factory.PersonsType;
import com.service.CoCreditorService;
import com.service.CoDebtorService;
import com.service.IncheiereService;
import com.service.PersonsService;
import com.service.SolidarCreditorService;
import com.service.SolidarDebtorService;

@Controller
@RequestMapping("persons")
public class PersonsController {

	@Autowired
	private PersonsService personServiceImpl;

	@Autowired
	private SolidarDebtorService solidarDebtorService;

	@Autowired
	private CoDebtorService coDebtorService;
	
	@Autowired
	private CoCreditorService coCreditorService;
	
	@Autowired
	private SolidarCreditorService solidarCreditorService;	

	@Autowired
	private IncheiereService incheiereService;

	@RequestMapping(value = { "/personsAdd" }, method = { RequestMethod.POST,
			RequestMethod.GET }, headers = { "Content-type=application/json" })
	public @ResponseBody Map<String, List<?>> PersonAdd(@RequestBody Persons person,
			@RequestParam(value = "type") String type,
			@RequestParam(value = "incheiere_id") int incheiere_id) {
		Map<String, List<?>> allPersonsMap = new HashMap<String, List<?>>();
		try {
			personServiceImpl.addPerson(person);
			switch (PersonsType.valueOf(type)) {
			case SolidarDebtor:
				solidarDebtorService.addPerson(new SolidarDebtor(person, incheiereService.getIncheiereById(incheiere_id)));	
				break;
			case CoDebtors: coDebtorService.addPerson(new CoDebtor(person, incheiereService.getIncheiereById(incheiere_id)));	
				break;
			case SolidarCreditor: solidarCreditorService.addPerson(new SolidarCreditor(person, incheiereService.getIncheiereById(incheiere_id)));	
				break;
			case CoCreditors: coCreditorService.addPerson(new CoCreditor(person, incheiereService.getIncheiereById(incheiere_id)));
				break;
			}
			allPersonsMap.put(PersonsType.SolidarDebtor.toString(), solidarDebtorService.getAllSolidarDebtorsByIncheiere(incheiere_id));	
			// TODO put CoDebtors
			// TODO put SolidarCreditor
			// TODO put CoCreditors
			
			PersonsFactory.addCorePerson(PersonsType.valueOf(type), person);
		} catch (Exception e) {
			// TODO exception logic here, implement DAO level exceptions
		}
		return allPersonsMap;
	}

	@RequestMapping(value = { "/personsGet" }, method = RequestMethod.GET)
	public @ResponseBody Map<String, List<?>> personsGet(
			@RequestParam(value = "type") String type,
			@RequestParam(value = "incheiere_id") int incheiere_id) {
		Map<String, List<?>> allPersonsMapByType = new HashMap<String, List<?>>();
		@SuppressWarnings("rawtypes")
		List<?> allPersonsListByType = new ArrayList();

		switch (PersonsType.valueOf(type)) {
		case SolidarDebtor:
			allPersonsListByType = solidarDebtorService.getAllSolidarDebtorsByIncheiere(incheiere_id);	
			allPersonsMapByType.put("solidari", allPersonsListByType);
			break;
		case CoDebtors: 
			allPersonsListByType = coDebtorService.getAllCoDebtorsByIncheiere(incheiere_id);	
			allPersonsMapByType.put("co", allPersonsListByType);
			break;
		case SolidarCreditor:
			allPersonsListByType = solidarCreditorService.getAllSolidarCreditorsByIncheiere(incheiere_id);	
			allPersonsMapByType.put("solidari", allPersonsListByType);
			break;
		case CoCreditors:
			allPersonsListByType = coCreditorService.getAllCoCreditorsByIncheiere(incheiere_id);	
			allPersonsMapByType.put("co", allPersonsListByType);
			break;
		}
		return allPersonsMapByType;
	}
//	 @RequestMapping(value = { "/personsEdit/{personId}" }, method =
//	 {RequestMethod.POST,RequestMethod.GET}, headers =
//	 {"Content-type=application/json"})
//	 public @ResponseBody String PersonEditTables(
//			 @RequestBody Persons p,
//			 @PathVariable("personId") int personId,
//			 @RequestParam(value = "type") String type,
//			 @RequestParam(value = "index") String index){
//	 try{
//	 int i=Integer.valueOf(index);
//	 personServiceImpl.updatePersons(p);
//	 PersonsFactory.editCorePerson(PersonsType.valueOf(p.getType()), p, i);
//	 }
//	 catch(Exception e){
//	 return "exists";
//	 }
//	 return "succes";
//	 }
//	 @RequestMapping(value = { "/personsDeleteDBTables" }, method =
//	 RequestMethod.POST, headers = {"Content-type=application/json"})
//	 public @ResponseBody String PersonDeleteDBTables(@RequestBody Persons p){
//	 try{
//	 personServiceImpl.deletePersons(p);
//	 PersonsFactory.deleteCorePerson(PersonsType.valueOf(p.getType()), p);
//	 }
//	 catch(Exception e){
//	 return "error";
//	 }
//	 return "succes";
//	 }
//	 @RequestMapping(value = { "/personsDeleteTables" }, method =
//	 RequestMethod.POST, headers = {"Content-type=application/json"})
//	 public @ResponseBody String PersonDeleteTables(@RequestBody Persons p){
//	 try{
//	
//	 PersonsFactory.deleteCorePerson(PersonsType.valueOf(p.getType()), p);
//	 }
//	 catch(Exception e){
//	 return "error";
//	 }
//	 return "succes";
//	 }
	
	 @RequestMapping(value = { "/personEdit/{idnp}" },
			 method ={RequestMethod.GET},
			 headers ={"Content-type=application/json"})
	 public @ResponseBody Persons initPersonEditForm(
			 @PathVariable("idnp") Long idnp){
	 return personServiceImpl.getPersonByIdnp(idnp);
	 }
	 
	 @RequestMapping(value = { "/personEdit/{idnp}" },
			 method ={RequestMethod.POST},
			 headers ={"Content-type=application/json"})
	 public @ResponseBody void processPersonUpdateForm(
			 @RequestBody Persons person){
	 personServiceImpl.updatePersons(person);
	 }

}
