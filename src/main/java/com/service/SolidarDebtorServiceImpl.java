package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.SolidarDebtorDAO;
import com.entities.Persons;
import com.entities.SolidarDebtor;

@Service
@Transactional
public class SolidarDebtorServiceImpl implements SolidarDebtorService {
	
	@Autowired
	private SolidarDebtorDAO solidarDebtorDAO;
	
	
	public void addPerson(SolidarDebtor debtor){
		solidarDebtorDAO.addPerson(debtor);
	}
	
	public void updatePersons(SolidarDebtor debtor){
		solidarDebtorDAO.updatePersons(debtor);
	}

	public void deletePersons(SolidarDebtor debtor){
		solidarDebtorDAO.deletePersons(debtor);
	}
	
	public List<SolidarDebtor> getAllSolidarDebtorsByIncheiere(int incheiere_id){
		return solidarDebtorDAO.getAllSolidarDebtorsByIncheiere(incheiere_id);
	}

}
