package com.DAO;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entities.Persons;


@Repository
public class PersonsDAOImpl implements PersonsDAO {
	@Autowired
	private SessionFactory sessionFactory;

//	@Override
//	public List<PersoanaFizica> getPersoaneFiziceByLastName(String lastname) {
//		return sessionFactory.getCurrentSession()
//				.createQuery("from PersoanaFizica where nume like CONCAT(:pattern,'%')")
//				.setParameter("pattern", lastname).list();
//	}
//
//	@Override
//	public List<PersoanaFizica> getPersoaneFiziceByIDNP(Long idnp) {
//		
//		
//		return sessionFactory.getCurrentSession()
//				.createQuery("from PersoanaFizica where idnp like CONCAT(:pattern,'%')")
//				.setParameter("pattern", idnp).list();
//	}
//	@Override
//	public PersoanaFizica getPersoanaFizicaByIDNP(Integer idnp) {
//		 return (PersoanaFizica) sessionFactory.getCurrentSession().load(
//				PersoanaFizica.class, idnp);
//	}

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
