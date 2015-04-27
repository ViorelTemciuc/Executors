package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.DebtorRepresentyDAO;
import com.entities.DebtorRepresenty;
import com.entities.Incheiere;
import com.entities.Persons;

@Service
@Transactional
public class DebtorRepresentyServiceImpl implements DebtorRepresentyService {
	
	@Autowired
	private DebtorRepresentyDAO debtorRepresentyDAO;
	
	
	public void addPerson(Persons person, Incheiere incheiere)throws Exception{
		
		debtorRepresentyDAO.addPerson(person, incheiere);
		
	}
	
	public void updatePersons(Persons person, Incheiere incheiere){
		debtorRepresentyDAO.updatePersons(person, incheiere);
	}

	public boolean deletePersons(Persons person, Incheiere incheiere){
		return debtorRepresentyDAO.deletePersons(person,incheiere);
	}
	
	public List<DebtorRepresenty> getAllDebtorRepresentysByIncheiere(int incheiere_id){
		return debtorRepresentyDAO.getAllDebtorRepresentysByIncheiere(incheiere_id);
	}

	
	@Override
	public DebtorRepresenty findDebtorRepresentyById(Persons person, Incheiere incheiere) {
		return debtorRepresentyDAO.findDebtorRepresentyById(person, incheiere);
	}

}
