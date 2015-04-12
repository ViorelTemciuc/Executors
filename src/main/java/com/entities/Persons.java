package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Persons")
@Entity
public class Persons {

	String name;
	Long idnp;
	String email="none";
	String adress1;
	String adress2;

		
	@Column(nullable = false, length = 50)
	public String getName() {
		return name;
	}

	public void setName(String nume) {
		this.name = nume;
	}
	
	@Id
	@Column(name = "idnp", unique = true, nullable = false)
	public long getIDNP() {
		return idnp;
	}

	public void setIDNP(Long idnp) {
		this.idnp = idnp;
	}

	@Column(nullable = false, length = 50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(nullable = false, length = 50)
	public String getAdress1() {
		return adress1;
	}

	public void setAdress1(String adress1) {
		this.adress1=adress1;
		
	}

	@Column(nullable = false, length = 50)
	public String getAdress2() {
		return this.adress2;
	}

	public void setAdress2(String adress2) {
		this.adress2=adress2;
	}
	
	
	
}
