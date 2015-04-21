package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.SolidarDebtorDAO;
import com.entities.Incheiere;
import com.entities.Persons;
import com.entities.SolidarDebtor;

@Service
@Transactional
public class SolidarDebtorServiceImpl implements SolidarDebtorService {
	
	@Autowired
	private SolidarDebtorDAO solidarDebtorDAO;
	
	
	public void addPerson(Persons person, Incheiere incheiere)throws Exception{
		solidarDebtorDAO.addPerson(person, incheiere);
	}
	
	public void updatePersons(Persons person, Incheiere incheiere){
		solidarDebtorDAO.updatePersons(person, incheiere);
	}

	public void deletePersons(SolidarDebtor debtor){
		solidarDebtorDAO.deletePersons(debtor);
	}
	
	public List<SolidarDebtor> getAllSolidarDebtorsByIncheiere(int incheiere_id){
		return solidarDebtorDAO.getAllSolidarDebtorsByIncheiere(incheiere_id);
	}

	@Override
	public SolidarDebtor findSolidarDebtorById(Persons person, Incheiere incheiere) {
		return	solidarDebtorDAO.findSolidarDebtorById(person, incheiere);
	}

}
