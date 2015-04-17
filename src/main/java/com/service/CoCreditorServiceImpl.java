package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.CoCreditorDAO;
import com.entities.CoCreditor;

@Service
@Transactional
public class CoCreditorServiceImpl implements CoCreditorService {
	
	@Autowired
	private CoCreditorDAO CoCreditorDAO;
	
	
	public void addPerson(CoCreditor creditor){
		CoCreditorDAO.addPerson(creditor);
	}
	
	public void updatePersons(CoCreditor creditor){
		CoCreditorDAO.updatePersons(creditor);
	}

	public void deletePersons(CoCreditor creditor){
		CoCreditorDAO.deletePersons(creditor);
	}
	
	public List<CoCreditor> getAllCoCreditorsByIncheiere(int incheiere_id){
		return CoCreditorDAO.getAllCoCreditorsByIncheiere(incheiere_id);
	}

}
