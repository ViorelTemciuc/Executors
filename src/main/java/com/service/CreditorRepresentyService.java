package com.service;

import java.util.List;

import com.entities.CreditorRepresenty;
import com.entities.Incheiere;
import com.entities.Persons;

public interface CreditorRepresentyService {

	public CreditorRepresenty findCreditorRepresentyById(Persons person, Incheiere incheiere);
	public void addPerson(Persons person, Incheiere incheiere)throws Exception;
	public void updatePersons(Persons person, Incheiere incheiere);
	public boolean deletePersons(Persons person, Incheiere incheiere);
	public List<CreditorRepresenty> getAllCreditorRepresentysByIncheiere(int incheiere_id);
}
