package com.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entities.Incheiere;

@Repository
public class IncheiereDAOImpl implements IncheiereDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Incheiere getIncheiereById(int id) {
		return (Incheiere) sessionFactory.getCurrentSession().get(
				Incheiere.class, id);		
	}

	@Override
	public void addIncheiere(Incheiere incheiere) {
		sessionFactory.getCurrentSession().save(incheiere);
	}

	@Override
	public void updateIncheiere(Incheiere incheiere) {
		sessionFactory.getCurrentSession().update(incheiere);
		
	}

	@Override
	public void deleteIncheiere(Incheiere incheiere) {
		sessionFactory.getCurrentSession().delete(incheiere);
		
	}
  
}
