package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.CoCreditorDAO;
import com.entities.CoCreditor;
import com.entities.Incheiere;
import com.entities.Persons;

@Service
@Transactional
public class CoCreditorServiceImpl implements CoCreditorService {
	
	@Autowired
	private CoCreditorDAO CoCreditorDAO;
	
public void addPerson(Persons person, Incheiere incheiere)throws Exception{
		
		CoCreditorDAO.addPerson(person, incheiere);
		
	}
	
	public void updatePersons(Persons person, Incheiere incheiere){
		CoCreditorDAO.updatePersons(person, incheiere);
	}

	public boolean deletePersons(Persons person, Incheiere incheiere){
		return CoCreditorDAO.deletePersons(person,incheiere);
	}
	
	public List<CoCreditor> getAllCoCreditorsByIncheiere(int incheiere_id){
		return CoCreditorDAO.getAllCoCreditorsByIncheiere(incheiere_id);
	}

	
	@Override
	public CoCreditor findCoCreditorById(Persons person, Incheiere incheiere) {
		return CoCreditorDAO.findCoCreditorById(person, incheiere);
	}

}
