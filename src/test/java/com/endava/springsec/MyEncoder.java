package com.endava.springsec;

import java.util.Date;

import org.Hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.Positions;
import com.entities.players;
import com.service.PersonsService;
 
@Component
public class MyEncoder {

	@Autowired
	static PersonsService schemaServiceImpl;
	@SuppressWarnings("deprecation")
	public static void main(String args[])
	{
		
	}

}
