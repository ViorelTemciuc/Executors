package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.CreditorRepresentyDAO;
import com.entities.CreditorRepresenty;
import com.entities.Incheiere;
import com.entities.Persons;

@Service
@Transactional
public class CreditorRepresentyServiceImpl implements CreditorRepresentyService {
	
	@Autowired
	private CreditorRepresentyDAO creditorRepresentyDAO;
	
	
	public void addPerson(Persons person, Incheiere incheiere)throws Exception{
		
		creditorRepresentyDAO.addPerson(person, incheiere);
		
	}
	
	public void updatePersons(Persons person, Incheiere incheiere){
		creditorRepresentyDAO.updatePersons(person, incheiere);
	}

	public boolean deletePersons(Persons person, Incheiere incheiere){
		return creditorRepresentyDAO.deletePersons(person,incheiere);
	}
	
	public List<CreditorRepresenty> getAllCreditorRepresentysByIncheiere(int incheiere_id){
		return creditorRepresentyDAO.getAllCreditorRepresentysByIncheiere(incheiere_id);
	}

	
	@Override
	public CreditorRepresenty findCreditorRepresentyById(Persons person, Incheiere incheiere) {
		return creditorRepresentyDAO.findCreditorRepresentyById(person, incheiere);
	}

}
