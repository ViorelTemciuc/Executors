package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.CoDebtorDAO;
import com.entities.CoDebtor;
import com.entities.Incheiere;
import com.entities.Persons;


@Service
@Transactional
public class CoDebtorServiceImpl implements CoDebtorService {
	
	@Autowired
	private CoDebtorDAO CoDebtorDAO;
	
	
	public void addPerson(Persons person, Incheiere incheiere)throws Exception{
		
		CoDebtorDAO.addPerson(person, incheiere);
		
	}
	
	public void updatePersons(Persons person, Incheiere incheiere){
		CoDebtorDAO.updatePersons(person, incheiere);
	}

	public boolean deletePersons(Persons person, Incheiere incheiere){
		return CoDebtorDAO.deletePersons(person,incheiere);
	}
	
	public List<CoDebtor> getAllCoDebtorsByIncheiere(int incheiere_id){
		return CoDebtorDAO.getAllCoDebtorsByIncheiere(incheiere_id);
	}

	
	@Override
	public CoDebtor findCoDebtorById(Persons person, Incheiere incheiere) {
		return CoDebtorDAO.findCoDebtorById(person, incheiere);
	}

}
