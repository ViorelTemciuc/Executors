package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="Judecatorie")
@Entity
public class Judecatorie {
	
	
	private String denumirea;
	private String orasul;
	private String sector;
	
	@Id
	@Column(name = "id_judecatorie")
	private int id_judecatorie;
	public int getId_judecatorie() {
		return id_judecatorie;
	}
	
	@Column(nullable=false,length=50)
	public String getDenumirea() {
		return denumirea;
	}
	@Column(nullable=false,length=50)
	public String getOrasul() {
		return orasul;
	}
	@Column(nullable=false,length=50)
	public String getSector() {
		return sector;
	}
	
	
	public void setId_judecatorie(int id_judecatorie) {
		this.id_judecatorie = id_judecatorie;
	}
	public void setDenumirea(String denumirea) {
		this.denumirea = denumirea;
	}
	public void setOrasul(String orasul) {
		this.orasul = orasul;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	
	

}
