package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entities.CoCreditor;
import com.entities.SolidarCreditor;

@Repository
public class CoCreditorDAOImpl implements CoCreditorDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addPerson(CoCreditor creditor) {
		sessionFactory.getCurrentSession().save(creditor);

	}

	@Override
	public void updatePersons(CoCreditor creditor) {
		sessionFactory.getCurrentSession().update(creditor);

	}

	@Override
	public void deletePersons(CoCreditor creditor) {
		sessionFactory.getCurrentSession().delete(creditor);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CoCreditor> getAllCoCreditorsByIncheiere(int incheiere_id) {

		Query query = sessionFactory.getCurrentSession().createQuery(
				"from CoCreditor where incheiere_id=:id_inch");
		query.setParameter("id_inch", incheiere_id);
		return (List<CoCreditor>) query.list();
	}

}
