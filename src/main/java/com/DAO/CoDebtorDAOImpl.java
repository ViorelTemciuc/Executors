package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entities.CoDebtor;
import com.entities.SolidarDebtor;

@Repository
public class CoDebtorDAOImpl implements CoDebtorDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addPerson(CoDebtor debtor) {
		sessionFactory.getCurrentSession().save(debtor);

	}

	@Override
	public void updatePersons(CoDebtor debtor) {
		sessionFactory.getCurrentSession().update(debtor);

	}

	@Override
	public void deletePersons(CoDebtor debtor) {
		sessionFactory.getCurrentSession().delete(debtor);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CoDebtor> getAllCoDebtorsByIncheiere(int incheiere_id) {

		Query query = sessionFactory.getCurrentSession().createQuery(
				"from CoDebtor where incheiere_id=:id_inch");
		query.setParameter("id_inch", incheiere_id);
		return (List<CoDebtor>) query.list();
	}

}
