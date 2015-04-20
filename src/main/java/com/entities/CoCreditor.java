package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "CoCreditor",
uniqueConstraints=@UniqueConstraint(columnNames={"person_id","incheiere_id"}))
public class CoCreditor {
	
	public CoCreditor(){}

	public CoCreditor(Persons person, Incheiere incheiere) {
		this.person = person;
		this.incheiere = incheiere;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "person_id")
	Persons person;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn
	Incheiere incheiere;
	
	public Persons getPerson() {
		return person;
	}
	public void setPerson(Persons person) {
		this.person = person;
	}
	public Incheiere getIncheiere() {
		return incheiere;
	}
	public void setIncheiere(Incheiere incheiere) {
		this.incheiere = incheiere;
	}
	
	
	

}
