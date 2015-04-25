package com.service;



import java.util.List;

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
	@Override
	 @Transactional
	 public List<Persons> searchPersonsListByDynamicName(String name) {
		// TODO Auto-generated method stub
		return personDAO.searchPersonsListByDynamicName(name);
	}
	@Override
	 @Transactional
	 public List<Persons> searchPersonListByDynamicIdnp(Long idnp) {
		// TODO Auto-generated method stub
		return personDAO.searchPersonListByDynamicIdnp(idnp);
	}
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
