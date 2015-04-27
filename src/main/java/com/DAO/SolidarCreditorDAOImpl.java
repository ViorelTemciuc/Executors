package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entities.Incheiere;
import com.entities.Persons;
import com.entities.SolidarCreditor;



@Repository
public class SolidarCreditorDAOImpl implements SolidarCreditorDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public SolidarCreditor findSolidarCreditorById(Persons person, Incheiere incheiere){
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from SolidarCreditor where incheiere_id=:id_inch and person_id=:id_person");
		query.setParameter("id_inch", incheiere.getId());
		query.setParameter("id_person", person.getIDNP());
		try{
		return (SolidarCreditor) query.list().get(0);
		}catch(Exception e){
			return null;
		}
	}
	@Override
	public void addPerson(Persons person, Incheiere incheiere) throws Exception {
		if(findSolidarCreditorById(person, incheiere) == null){
		  SolidarCreditor debtor = new SolidarCreditor(person, incheiere);
		sessionFactory.getCurrentSession().save(debtor);
		}
		else {
			throw new Exception();
		}
	}

	@Override
	public void updatePersons(Persons person, Incheiere incheiere) {
		SolidarCreditor debtor;
		try{
			debtor=findSolidarCreditorById(person, incheiere) ;
			debtor.setIncheiere(incheiere);
			debtor.setPerson(person);
			sessionFactory.getCurrentSession().update(debtor);
		} catch(Exception e) {
			debtor=new SolidarCreditor(person, incheiere);	
			sessionFactory.getCurrentSession().save(debtor);
		}
		
		
			
	}

	@Override
	public boolean deletePersons(Persons person, Incheiere incheiere) {
		
		if(findSolidarCreditorById(person, incheiere) != null){
			  SolidarCreditor debtor = findSolidarCreditorById(person, incheiere);
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
				"from SolidarCreditor where person_id=:id_person");
		query.setParameter("id_inch", person.getIDNP());
		if(query.list().size()>0)
			return true;
		else return false;
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
