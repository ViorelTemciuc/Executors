package com.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.AddCorePersonsException;
import com.DAO.PersonsDAO;
import com.entities.Persons;




@Service
public class PersonsServiceImpl implements PersonsService {

	@Autowired
	private PersonsDAO personDAO;
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
	public void addPerson(Persons person,boolean update) throws AddCorePersonsException{
		if(!update)
	    personDAO.addPrivatePerson(person);
		else throw new AddCorePersonsException();
	}
	@Override
	@Transactional
	public void updatePersons(Persons p){
		 personDAO.updatePersons(p);
	}
	@Override
	@Transactional
	public void deletePersons(Persons p){
	    personDAO.deletePersons(p);
	}
	@Override
	@Transactional
	public Persons getPersonByIdnp(Long idnp) {
		return personDAO.getPersonByIdnp(idnp);
	}


}
