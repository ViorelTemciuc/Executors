package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.IncheiereDAO;
import com.entities.Incheiere;

@Service
public class IncheiereServiceImpl implements IncheiereService {
	
	@Autowired
	private IncheiereDAO incheiereDAO;
	
	@Transactional
	@Override
	public Incheiere getIncheiereById(int id) {
		return incheiereDAO.getIncheiereById(id);
	}
	@Transactional
	@Override
	public void addIncheiere(Incheiere incheiere) {
		incheiereDAO.addIncheiere(incheiere);

	}
	@Transactional
	@Override
	public void updateIncheiere(Incheiere incheiere) {
		incheiereDAO.updateIncheiere(incheiere);

	}
	@Transactional
	@Override
	public void deleteIncheiere(Incheiere incheiere) {
		incheiereDAO.deleteIncheiere(incheiere);

	}

}
