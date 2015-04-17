package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.SolidarCreditorDAO;
import com.DAO.SolidarDebtorDAO;
import com.entities.Persons;
import com.entities.SolidarCreditor;
import com.entities.SolidarDebtor;

@Service
@Transactional
public class SolidarCreditorServiceImpl implements SolidarCreditorService {
	
	@Autowired
	private SolidarCreditorDAO solidarCreditorDAO;
	
	
	public void addPerson(SolidarCreditor creditor){
		solidarCreditorDAO.addPerson(creditor);
	}
	
	public void updatePersons(SolidarCreditor creditor){
		solidarCreditorDAO.updatePersons(creditor);
	}

	public void deletePersons(SolidarCreditor creditor){
		solidarCreditorDAO.deletePersons(creditor);
	}
	
	public List<SolidarCreditor> getAllSolidarCreditorsByIncheiere(int incheiere_id){
		return solidarCreditorDAO.getAllSolidarCreditorsByIncheiere(incheiere_id);
	}

}
