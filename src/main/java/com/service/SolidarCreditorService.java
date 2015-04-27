package com.service;

import java.util.List;

import com.entities.Incheiere;
import com.entities.Persons;
import com.entities.SolidarCreditor;

public interface SolidarCreditorService {
	public SolidarCreditor findSolidarCreditorById(Persons person, Incheiere incheiere);
	public void addPerson(Persons person, Incheiere incheiere)throws Exception;
	public void updatePersons(Persons person, Incheiere incheiere);
	public boolean deletePersons(Persons person, Incheiere incheiere);
	public List<SolidarCreditor> getAllSolidarCreditorsByIncheiere(int incheiere_id);
}
