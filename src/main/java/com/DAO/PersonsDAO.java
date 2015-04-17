package com.DAO;

import com.entities.Persons;



//import com.entities.PersoanaFizica;

public interface PersonsDAO {
//	public List<PersoanaFizica> getPersoaneFiziceByLastName(String lastname);
//	public List<PersoanaFizica> getPersoaneFiziceByIDNP(Long idnp);
	public Persons getPersonByIdnp(Long idnp);
	public void addPrivatePerson(Persons person);
	public void updatePersons(Persons p);
	public void deletePersons(Persons p);

}
