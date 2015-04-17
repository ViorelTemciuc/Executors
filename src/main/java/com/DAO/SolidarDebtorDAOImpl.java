package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entities.SolidarDebtor;

@Repository
public class SolidarDebtorDAOImpl implements SolidarDebtorDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addPerson(SolidarDebtor debtor) {
		sessionFactory.getCurrentSession().save(debtor);

	}

	@Override
	public void updatePersons(SolidarDebtor debtor) {
		sessionFactory.getCurrentSession().update(debtor);

	}

	@Override
	public void deletePersons(SolidarDebtor debtor) {
		sessionFactory.getCurrentSession().delete(debtor);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SolidarDebtor> getAllSolidarDebtorsByIncheiere(int incheiere_id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from SolidarDebtor where incheiere_id=:id_inch");
		query.setParameter("id_inch", incheiere_id);
		return (List<SolidarDebtor>) query.list();
		
		// return (List<SolidarDebtor>) // sessionFactory.getCurrentSession().get(SolidarDebtor.class, incheiere_id);
	}

}
