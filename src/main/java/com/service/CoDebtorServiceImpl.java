package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.CoDebtorDAO;
import com.entities.CoDebtor;

@Service
@Transactional
public class CoDebtorServiceImpl implements CoDebtorService {
	
	@Autowired
	private CoDebtorDAO CoDebtorDAO;
	
	
	public void addPerson(CoDebtor debtor){
		CoDebtorDAO.addPerson(debtor);
	}
	
	public void updatePersons(CoDebtor debtor){
		CoDebtorDAO.updatePersons(debtor);
	}

	public void deletePersons(CoDebtor debtor){
		CoDebtorDAO.deletePersons(debtor);
	}
	
	public List<CoDebtor> getAllCoDebtorsByIncheiere(int incheiere_id){
		return CoDebtorDAO.getAllCoDebtorsByIncheiere(incheiere_id);
	}

}
