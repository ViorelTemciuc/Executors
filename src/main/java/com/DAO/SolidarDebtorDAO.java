package com.DAO;

import java.util.List;

import com.entities.Incheiere;
import com.entities.Persons;
import com.entities.SolidarDebtor;


public interface SolidarDebtorDAO {
	public SolidarDebtor findSolidarDebtorById(Persons person, Incheiere incheiere);
	public void addPerson(Persons person, Incheiere incheiere)throws Exception;
	public void updatePersons(Persons person, Incheiere incheiere);
	public void deletePersons(Persons person, Incheiere incheiere);
	public List<SolidarDebtor> getAllSolidarDebtorsByIncheiere(int incheiere_id);
}
