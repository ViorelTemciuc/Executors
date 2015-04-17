package com.service;

import java.util.List;

import com.entities.CoDebtor;

public interface CoDebtorService {
	public void addPerson(CoDebtor debtor);
	public void updatePersons(CoDebtor debtor);
	public void deletePersons(CoDebtor debtor);
	public List<CoDebtor> getAllCoDebtorsByIncheiere(int incheiere_id);
}
