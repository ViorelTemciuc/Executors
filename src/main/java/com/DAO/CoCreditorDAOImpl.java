package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entities.CoCreditor;
import com.entities.Incheiere;
import com.entities.Persons;


@Repository
public class CoCreditorDAOImpl implements CoCreditorDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CoCreditor findCoCreditorById(Persons person, Incheiere incheiere){
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from CoCreditor where incheiere_id=:id_inch and person_id=:id_person");
		query.setParameter("id_inch", incheiere.getId());
		query.setParameter("id_person", person.getIDNP());
		try{
		return (CoCreditor) query.list().get(0);
		}catch(Exception e){
			return null;
		}
	}
	@Override
	public void addPerson(Persons person, Incheiere incheiere) throws Exception {
		if(findCoCreditorById(person, incheiere) == null){
			  CoCreditor debtor = new CoCreditor(person, incheiere);
			sessionFactory.getCurrentSession().save(debtor);
			}
			else {
				throw new Exception();
			}
	}

	@Override
	public void updatePersons(Persons person, Incheiere incheiere) {
		CoCreditor debtor;
		try{
			debtor=findCoCreditorById(person, incheiere) ;
			debtor.setIncheiere(incheiere);
			debtor.setPerson(person);
			sessionFactory.getCurrentSession().update(debtor);
		} catch(Exception e) {
			debtor=new CoCreditor(person, incheiere);	
			sessionFactory.getCurrentSession().save(debtor);
		}
	}

	@Override
	public boolean deletePersons(Persons person, Incheiere incheiere) {
		
		if(findCoCreditorById(person, incheiere) != null){
			  CoCreditor debtor = findCoCreditorById(person, incheiere);
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
				"from CoCreditor where person_id=:id_person");
		query.setParameter("id_inch", person.getIDNP());
		if(query.list().size()>0)
			return true;
		else return false;
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
