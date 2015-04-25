package com.service;

import java.util.List;

import com.DAO.AddCorePersonsException;
import com.entities.Persons;

//import com.entities.PersoanaFizica;

public interface PersonsService {
	
	public List<Persons> searchPersonsListByDynamicName(String name);
	public List<Persons> searchPersonListByDynamicIdnp(Long idnp);
    public Persons getPersonByIdnp(Long idnp);
	public void addPerson(Persons person,boolean update)throws AddCorePersonsException;	
	public void deletePersons(Persons p);
	public void updatePersons(Persons person);

}
