package com.DAO;

import java.util.List;

import com.entities.Persons;

public interface PersonsDAO {

	public Persons getPersonByIdnp(Long idnp);
	public List<Persons> searchPersonListByDynamicIdnp(Long idnp);
	public List<Persons> searchPersonsListByDynamicName(String name);
	public void addPrivatePerson(Persons person);
	public void updatePersons(Persons p);
	public void deletePersons(Persons p);

}
