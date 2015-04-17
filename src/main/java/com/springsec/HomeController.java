package com.springsec;



import javax.servlet.ServletContext;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.form.persons.Factory.FormFactory;
import com.form.persons.Factory.FormType;

import com.service.PersonsService;


//import com.entities.PersoanaFizica;
//import com.entities.PersoanaJuridica;
//import com.entities.PrivatePerson;
//import com.service.PersoanaFizicaService;
//import com.service.PersoanaJuridicaService;
//import com.service.PersoanaJuridicaServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller

public class HomeController {

	@Autowired
	ServletContext context;
	@Autowired
	private PersonsService personServiceImpl;

	
	@RequestMapping(value = { "/initPersonsAddForm" }, method = RequestMethod.GET)
	public @ResponseBody String initPersonsAddForm(@RequestParam(value = "formType") String type){
			return FormFactory.generateForm(FormType.valueOf(type),context);			
}
//	@RequestMapping(value = { "/personsJurAdd" }, method = RequestMethod.POST,headers = {"Content-type=application/json"})
//	public @ResponseBody String insertNewJurPerson(@RequestBody PersoanaJuridica pj){
//		try{
//	    PersoanaJuridicaServiceImpl.addPersoanaJuridica(pj);
//		
//		}
//		catch(Exception e){
//			return "exists";
//		}
//		return pj.getDenumire()+ " "  + " /" + pj.getIdnp();
//}
//	@RequestMapping(value = { "/personsFizAdd/update" }, method = RequestMethod.POST,headers = {"Content-type=application/json"})
//	public @ResponseBody String updatePerson(@RequestBody PersoanaFizica pf){
//		
//		PersoanaFizicaServiceImpl.updatePersoanaFizica(pf);
//		
//		return pf.getNume()+ " " + pf.getPrenume() + " /" + pf.getIdnp();
//}
//	@RequestMapping(value = { "/personsJurAdd/update" }, method = RequestMethod.POST,headers = {"Content-type=application/json"})
//	public @ResponseBody String updateJurPerson(@RequestBody PersoanaJuridica pj){
//		
//		PersoanaJuridicaServiceImpl.updatePersoanaJuridica(pj);
//		
//		return pj.getDenumire()+ " /" + pj.getIdnp();
//}
//	@RequestMapping(value = { "/personsFizAdd/delete" }, method = RequestMethod.POST,headers = {"Content-type=application/json"})
//	public @ResponseBody String deletePerson(@RequestBody PersoanaFizica pf){
//		
//		PersoanaFizicaServiceImpl.removePersoanaFizica(pf);
//		
//		return pf.getNume()+ " " + pf.getPrenume() + " /" + pf.getIdnp();
//}
//	@RequestMapping(value = { "/personsJurAdd/delete" }, method = RequestMethod.POST,headers = {"Content-type=application/json"})
//	public @ResponseBody String deleteJurPerson(@RequestBody PersoanaJuridica pj){
//		
//		PersoanaJuridicaServiceImpl.removePersoanaJuridica(pj);
//		return pj.getDenumire()+ " /" + pj.getIdnp();
//}
//	
//	@RequestMapping(value = { "/personsFizAdd/searchIdnp" })
//	public @ResponseBody List<PersoanaFizica> searchPersonByIdnp(
//			@RequestParam(value = "idnp") Long idnp
//			){
//		
//		return PersoanaFizicaServiceImpl.getPersoaneFiziceByIDNP(idnp);
//			}
//	
//	@RequestMapping(value = { "/personsFizAdd/searchName" })
//	public @ResponseBody List<PersoanaFizica> searchPersonByName(
//			@RequestParam(value = "name") String nume
//			){
//		
//		return PersoanaFizicaServiceImpl.getPersoaneFiziceByLastName(nume);
//			}
//	@RequestMapping(value = { "/personsRead" })
//	public @ResponseBody PersoanaFizica selectPerson(
//			@RequestParam(value = "idnp") int idnp
//			){
//		
//		return PersoanaFizicaServiceImpl.getPersoanaFizicaByIDNP(idnp);
//			}
//	
//	@RequestMapping(value = { "executors/getPersonsList" }, method = RequestMethod.GET ,headers = {"Content-type=application/json"} )
//	public @ResponseBody List<?> getPersonsList(@RequestParam(value = "type") String criteria){
//	    PersonsTable pt=PersonsFactory.getPersonsTable(criteria);
//	    return pt.getPersonsList();
//		
//	}
//	@RequestMapping(value = { "/getForm" }, method = RequestMethod.GET)
//	public @ResponseBody String getForm(@RequestParam(value = "jurStatus") String jurStatus){
//		return FormFactory.generateForm(FormType.valueOf(jurStatus));
//				
//    }	
	@RequestMapping(value = { "/" })
	public String  index() {
		return "home";
	}
//	
 
	//Spring Security see this :
	
 
	
}
