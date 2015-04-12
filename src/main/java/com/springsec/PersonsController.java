package com.springsec;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entities.Persons;
import com.list.persons.Factory.PersonsFactory;
import com.list.persons.Factory.PersonsType;
import com.service.PersonsService;

@Controller
@RequestMapping("persons")
public class PersonsController {
	
	@Autowired
	private PersonsService personServiceImpl;
	
	@RequestMapping(value = { "/personsAdd" }, method ={ RequestMethod.POST,RequestMethod.GET}, headers = {"Content-type=application/json"})
	public @ResponseBody String PersonAdd(@RequestBody Persons p,@RequestParam(value = "type") String type){
		try{
			personServiceImpl.addPerson(p);//hibernate
			PersonsFactory.addCorePerson(PersonsType.valueOf(type), p);			
		}
		catch(Exception e){
			return "exists";
		}
		return "succes";
}
	@RequestMapping(value = { "/personsGet" }, method = RequestMethod.GET)
	public @ResponseBody List<?> PersonAddGet(@RequestParam(value = "type") String type){
		return PersonsFactory.getCorePersonsList(PersonsType.valueOf(type));	
		
    }	
//	@RequestMapping(value = { "/personsEdit" }, method = {RequestMethod.POST,RequestMethod.GET}, headers = {"Content-type=application/json"})
//	public @ResponseBody String PersonEditTables(@RequestBody Persons p,@RequestParam(value = "index") String index){
//		try{
//			int i=Integer.valueOf(index);
//			personServiceImpl.updatePersons(p);
//			PersonsFactory.editCorePerson(PersonsType.valueOf(p.getType()), p, i);		
//		}
//		catch(Exception e){
//			return "exists";
//		}
//		return "succes";
//}
//	@RequestMapping(value = { "/personsDeleteDBTables" }, method = RequestMethod.POST, headers = {"Content-type=application/json"})
//	public @ResponseBody String PersonDeleteDBTables(@RequestBody Persons p){
//		try{
//			personServiceImpl.deletePersons(p);
//			PersonsFactory.deleteCorePerson(PersonsType.valueOf(p.getType()), p);		
//		}
//		catch(Exception e){
//			return "error";
//		}
//		return "succes";
//}
//	@RequestMapping(value = { "/personsDeleteTables" }, method = RequestMethod.POST, headers = {"Content-type=application/json"})
//	public @ResponseBody String PersonDeleteTables(@RequestBody Persons p){
//		try{
//			
//			PersonsFactory.deleteCorePerson(PersonsType.valueOf(p.getType()), p);		
//		}
//		catch(Exception e){
//			return "error";
//		}
//		return "succes";
//}
}
