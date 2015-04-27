package com.service;

import java.util.List;

import com.entities.DebtorRepresenty;
import com.entities.Incheiere;
import com.entities.Persons;

public interface DebtorRepresentyService {

	public DebtorRepresenty findDebtorRepresentyById(Persons person, Incheiere incheiere);
	public void addPerson(Persons person, Incheiere incheiere)throws Exception;
	public void updatePersons(Persons person, Incheiere incheiere);
	public boolean deletePersons(Persons person, Incheiere incheiere);
	public List<DebtorRepresenty> getAllDebtorRepresentysByIncheiere(int incheiere_id);
}
