package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entities.SolidarCreditor;

@Repository
public class SolidarCreditorDAOImpl implements SolidarCreditorDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addPerson(SolidarCreditor creditor) {
		sessionFactory.getCurrentSession().save(creditor);

	}

	@Override
	public void updatePersons(SolidarCreditor creditor) {
		sessionFactory.getCurrentSession().update(creditor);

	}

	@Override
	public void deletePersons(SolidarCreditor creditor) {
		sessionFactory.getCurrentSession().delete(creditor);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SolidarCreditor> getAllSolidarCreditorsByIncheiere(int incheiere_id) {

		Query query = sessionFactory.getCurrentSession().createQuery(
				"from SolidarCreditor where incheiere_id=:id_inch");
		query.setParameter("id_inch", incheiere_id);
		return (List<SolidarCreditor>) query.list();
	}

}
