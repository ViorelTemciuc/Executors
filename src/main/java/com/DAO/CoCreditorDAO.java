package com.DAO;

import java.util.List;

import com.entities.CoCreditor;


public interface CoCreditorDAO {
	public void addPerson(CoCreditor creditor);
	public void updatePersons(CoCreditor creditor);
	public void deletePersons(CoCreditor creditor);
	public List<CoCreditor> getAllCoCreditorsByIncheiere(int incheiere_id);
}
