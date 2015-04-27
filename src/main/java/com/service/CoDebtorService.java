package com.service;

import java.util.List;

import com.entities.CoDebtor;
import com.entities.Incheiere;
import com.entities.Persons;

public interface CoDebtorService {
	public CoDebtor findCoDebtorById(Persons person, Incheiere incheiere);
	public void addPerson(Persons person, Incheiere incheiere)throws Exception;
	public void updatePersons(Persons person, Incheiere incheiere);
	public boolean deletePersons(Persons person, Incheiere incheiere);
	public List<CoDebtor> getAllCoDebtorsByIncheiere(int incheiere_id);
}
