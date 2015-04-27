package com.DAO;

import java.util.List;

import com.entities.CoCreditor;
import com.entities.Incheiere;
import com.entities.Persons;


public interface CoCreditorDAO {
	public CoCreditor findCoCreditorById(Persons person, Incheiere incheiere);
	public void addPerson(Persons person, Incheiere incheiere) throws Exception ;
	public void updatePersons(Persons person, Incheiere incheiere);
	public boolean deletePersons(Persons person, Incheiere incheiere); 
	public List<CoCreditor> getAllCoCreditorsByIncheiere(int incheiere_id);
}
