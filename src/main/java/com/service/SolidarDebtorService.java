package com.service;

import java.util.List;

import com.entities.SolidarDebtor;

public interface SolidarDebtorService {
	public void addPerson(SolidarDebtor debtor);
	public void updatePersons(SolidarDebtor debtor);
	public void deletePersons(SolidarDebtor debtor);
	public List<SolidarDebtor> getAllSolidarDebtorsByIncheiere(int incheiere_id);
}
