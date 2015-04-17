package com.service;

import com.entities.Persons;

//import com.entities.PersoanaFizica;

public interface PersonsService {
	
//	public List<PersoanaFizica> getPersoaneFiziceByLastName(String lastname);
//	public PersoanaFizica getPersoanaFizicaByIDNP(Integer idnp) ;
    public Persons getPersonByIdnp(Long idnp);
	public void addPerson(Persons person);	
	public void deletePersons(Persons p);
	public void updatePersons(Persons person);

}
