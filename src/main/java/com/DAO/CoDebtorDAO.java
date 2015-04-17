package com.DAO;

import java.util.List;

import com.entities.CoDebtor;


public interface CoDebtorDAO {
	public void addPerson(CoDebtor debtor);
	public void updatePersons(CoDebtor debtor);
	public void deletePersons(CoDebtor debtor);
	public List<CoDebtor> getAllCoDebtorsByIncheiere(int incheiere_id);
}
