package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entities.Incheiere;
import com.entities.Persons;
import com.entities.SolidarDebtor;

@Repository
public class SolidarDebtorDAOImpl implements SolidarDebtorDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public SolidarDebtor findSolidarDebtorById(Persons person, Incheiere incheiere){
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from SolidarDebtor where incheiere_id=:id_inch and person_id=:id_person");
		query.setParameter("id_inch", incheiere.getId());
		query.setParameter("id_person", person.getIDNP());
		try{
		return (SolidarDebtor) query.list().get(0);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public void addPerson(Persons person, Incheiere incheiere) throws Exception {
		if(findSolidarDebtorById(person, incheiere) == null){
		  SolidarDebtor debtor = new SolidarDebtor(person, incheiere);
		sessionFactory.getCurrentSession().save(debtor);
		}
		else {
			throw new Exception();
		}
	}

	@Override
	public void updatePersons(Persons person, Incheiere incheiere) {
		SolidarDebtor debtor;
		try{
			debtor=findSolidarDebtorById(person, incheiere) ;
			debtor.setIncheiere(incheiere);
			debtor.setPerson(person);
			sessionFactory.getCurrentSession().update(debtor);
		} catch(Exception e) {
			debtor=new SolidarDebtor(person, incheiere);	
			sessionFactory.getCurrentSession().save(debtor);
		}
		
		
			
	}

	@Override
	public boolean deletePersons(Persons person, Incheiere incheiere) {
		
		if(findSolidarDebtorById(person, incheiere) != null){
			  SolidarDebtor debtor = findSolidarDebtorById(person, incheiere);
			  sessionFactory.getCurrentSession().delete(debtor);
			  if(!checkIfPersonExistInOtherIncheieriOnDelete(person)){				  
				  return true;
			  }
			  else {
				  return false;
			  }
				  
		}
		else{
			return false;
		}
	}
    private boolean checkIfPersonExistInOtherIncheieriOnDelete(Persons person){
    	Query query = sessionFactory.getCurrentSession().createQuery(
				"from SolidarDebtor where person_id=:id_person");
		query.setParameter("id_person", person.getIDNP());
		if(query.list().size()>0)
			return true;
		else return false;
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
