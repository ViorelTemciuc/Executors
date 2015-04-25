package com.DAO;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entities.Persons;


@Repository
public class PersonsDAOImpl implements PersonsDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Persons> searchPersonsListByDynamicName(String name) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Persons where name like CONCAT(:pattern,'%')")
				.setParameter("pattern", name).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persons> searchPersonListByDynamicIdnp(Long idnp) {
		
		
		return sessionFactory.getCurrentSession()
				.createQuery("from Persons where idnp like CONCAT(:pattern,'%')")
				.setParameter("pattern", idnp).list();
	}
	@Override
	public Persons getPersonByIdnp(Long idnp) {
		 return (Persons) sessionFactory.getCurrentSession().get(
				Persons.class, idnp);
	}

	@Override
	public void addPrivatePerson(Persons person) {
		sessionFactory.getCurrentSession().save(person);

	}
	@Override
	public void updatePersons(Persons p) {
		 sessionFactory.getCurrentSession().update(p);
	
	}
	@Override
	public void deletePersons(Persons p) {
		sessionFactory.getCurrentSession().delete(p);
	}
}
