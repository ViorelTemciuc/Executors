package com.DAO;

import java.util.List;

import com.entities.SolidarCreditor;


public interface SolidarCreditorDAO {
	public void addPerson(SolidarCreditor creditor);
	public void updatePersons(SolidarCreditor creditor);
	public void deletePersons(SolidarCreditor creditor);
	public List<SolidarCreditor> getAllSolidarCreditorsByIncheiere(int incheiere_id);
}
