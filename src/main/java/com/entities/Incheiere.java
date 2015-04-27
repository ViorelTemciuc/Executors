package com.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




@Entity
@Table(name="Incheieri")
public class Incheiere {
	private int id;
	private Date data;
	private Judecatorie judecatorie ;
	private String optiuni;
	private int nr_hotarire_executare;
	private int nr_procedura_executare;
	private String descriere_incheiere;
	private Set<Category> categories = new HashSet<Category>(0);
	
	public Incheiere() {
		// TODO Auto-generated constructor stub
	}
	public Incheiere(Set<Category> categories) {
		this.categories = categories;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "data")
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_judecatorie", nullable = false)
	public Judecatorie getJudecatorie() {
		return judecatorie;
	}
	public void setJudecatorie(Judecatorie judecatorie) {
		this.judecatorie = judecatorie;
	}
	@Column(name = "optiuni")
	public String getOptiuni() {
		return optiuni;
	}
	public void setOptiuni(String optiuni) {
		this.optiuni = optiuni;
	}
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "nr_hotarire_executare", unique = true, nullable = false)
	public int getNr_hotarire_executare() {
		return nr_hotarire_executare;
	}
	public void setNr_hotarire_executare(int nr_hotarire_executare) {
		this.nr_hotarire_executare = nr_hotarire_executare;
	}
	@Column(name = "nr_procedura_executare", unique = true, nullable = false)
	public int getNr_procedura_executare() {
		return nr_procedura_executare;
	}
	public void setNr_procedura_executare(int nr_procedura_executare) {
		this.nr_procedura_executare = nr_procedura_executare;
	}
	@Column(name = "descriere_incheiere")
	public String getDescriere_incheiere() {
		return descriere_incheiere;
	}
	public void setDescriere_incheiere(String descriere_incheiere) {
		this.descriere_incheiere = descriere_incheiere;
	}
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "incheieri_category", joinColumns = { 
			@JoinColumn(name = "id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "CATEGORY_ID", 
					nullable = false, updatable = false) })
	public Set<Category> getCategories() {
		return this.categories;
	}
 
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
}
