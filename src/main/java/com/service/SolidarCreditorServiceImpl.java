package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.SolidarCreditorDAO;
import com.entities.Incheiere;
import com.entities.Persons;
import com.entities.SolidarCreditor;

@Service
@Transactional
public class SolidarCreditorServiceImpl implements SolidarCreditorService {
	
	@Autowired
	private SolidarCreditorDAO solidarCreditorDAO;
	
	
	public void addPerson(Persons person, Incheiere incheiere)throws Exception{
		
		solidarCreditorDAO.addPerson(person, incheiere);
		
	}
	
	public void updatePersons(Persons person, Incheiere incheiere){
		solidarCreditorDAO.updatePersons(person, incheiere);
	}

	public boolean deletePersons(Persons person, Incheiere incheiere){
		return solidarCreditorDAO.deletePersons(person,incheiere);
	}
	
	public List<SolidarCreditor> getAllSolidarCreditorsByIncheiere(int incheiere_id){
		return solidarCreditorDAO.getAllSolidarCreditorsByIncheiere(incheiere_id);
	}

	public SolidarCreditor findSolidarCreditorById(Persons person, Incheiere incheiere) {
		return	solidarCreditorDAO.findSolidarCreditorById(person, incheiere);
	}

	

}
