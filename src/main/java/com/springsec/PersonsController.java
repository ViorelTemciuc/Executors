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

import com.DAO.AddCorePersonsException;
import com.entities.Persons;
import com.list.persons.Factory.PersonsAddFactory;
import com.list.persons.Factory.PersonsListFactory;
import com.service.PersonsService;


@Controller
@RequestMapping("persons")
public class PersonsController {

	@Autowired
	private PersonsService personServiceImpl;

	@Autowired
	private PersonsListFactory personsListFactory;
	
	@Autowired
	private PersonsAddFactory personsAddFactory;

	

	@RequestMapping(value = { "/personsAdd" }, method = { RequestMethod.POST,
			RequestMethod.GET }, headers = { "Content-type=application/json" })
	public @ResponseBody Map<String, List<?>> PersonAdd(@RequestBody Persons person,
			@RequestParam(value = "type") String type,
			@RequestParam(value = "incheiere_id") int incheiere_id,
			@RequestParam(value = "update") boolean update) {
		Map <String,List<?>> duplicateEntries=new HashMap<String, List<?>>();
		try {
			 personServiceImpl.addPerson(person,update);
			return personsAddFactory.addCorePersons(type, incheiere_id, person);
			
					    
		} 
		catch(AddCorePersonsException e){
			 personServiceImpl.updatePersons(person);
			 return personsAddFactory.updateCorePersons(type, incheiere_id, person);
		}
		catch (Exception e) {
			List<Persons> persons=new ArrayList<Persons>();
			persons.add(personServiceImpl.getPersonByIdnp(person.getIDNP()));
			persons.add(person);
			duplicateEntries.put("duplicate",persons);
			return duplicateEntries;
			// returns source data for duplicate table
			
		}
		
	}
	
	// row double click on duplicate table
	@RequestMapping(value = { "/personsForceAdd" }, method = { RequestMethod.POST,
			RequestMethod.GET }, headers = { "Content-type=application/json" })
	public @ResponseBody Map<String, List<?>> PersonAddForce(@RequestBody Persons person,
			@RequestParam(value = "type") String type,
			@RequestParam(value = "incheiere_id") int incheiere_id,
			@RequestParam(value = "update") boolean update) {
			 personServiceImpl.updatePersons(person);
			 try{
			 return personsAddFactory.addCorePersons(type, incheiere_id, person);
			 }
					    
		 catch (Exception e) {
			 return personsAddFactory.updateCorePersons(type, incheiere_id, person);
		}
		
	}
	@RequestMapping(value = { "/personsDelete" }, method = { RequestMethod.POST,
			RequestMethod.GET }, headers = { "Content-type=application/json" })
	public @ResponseBody Map<String, List<?>> personsDelete(@RequestBody Persons person,
			@RequestParam(value = "type") String type,
			@RequestParam(value = "incheiere_id") int incheiere_id,
			@RequestParam(value = "personsTable") boolean update) {
		 	 
			 return personsAddFactory.deleteCorePersons(type, incheiere_id, person,update);
		
	}
	@RequestMapping(value = { "/personsGet" }, method = RequestMethod.GET)
	public @ResponseBody Map<String, List<?>> personsGet(
			@RequestParam(value = "type") String type,
			@RequestParam(value = "incheiere_id") int incheiere_id) {
		
		
		return personsListFactory.getCorePersons(type, incheiere_id);
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
