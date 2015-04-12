package com.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.PersonsDAO;
import com.entities.Persons;




@Service
public class PersonsServiceImpl implements PersonsService {

	@Autowired
	private PersonsDAO pfDAO;
//	@Override
//	 @Transactional
//	 public List<PrivatePerson> getPersoaneFiziceByLastName(String lastname) {
//		// TODO Auto-generated method stub
//		return pfDAO.getPersoaneFiziceByLastName(lastname);
//	}
//	@Override
//	 @Transactional
//	 public List<PersoanaFizica> getPersoaneFiziceByIDNP(Long idnp) {
//		// TODO Auto-generated method stub
//		return pfDAO.getPersoaneFiziceByIDNP(idnp);
//	}
	@Override
	 @Transactional
	public void addPerson(Persons person){
	    pfDAO.addPrivatePerson(person);
	}
	@Override
	@Transactional
	public void updatePersons(Persons p){
	    pfDAO.updatePersons(p);
	}
	@Override
	@Transactional
	public void deletePersons(Persons p){
	    pfDAO.deletePersons(p);
	}
//	@Override
//	@Transactional
//	public PersoanaFizica getPersoanaFizicaByIDNP(Integer idnp) {
//		return pfDAO.getPersoanaFizicaByIDNP(idnp);
//	}


}
