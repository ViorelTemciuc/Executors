package com.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@SuppressWarnings("serial")
@Entity
@Table(name = "category")
public class Category implements java.io.Serializable {
 
	private Integer categoryId;
	private String name;
	private String desc;
	private Set<Incheiere> incheieri = new HashSet<Incheiere>(0);
 
	public Category() {
	}
 
	public Category(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
 
	public Category(String name, String desc, Set<Incheiere> incheieri) {
		this.name = name;
		this.desc = desc;
		this.incheieri = incheieri;
	}
 
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CATEGORY_ID", unique = true, nullable = false)
	public Integer getCategoryId() {
		return this.categoryId;
	}
 
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
 
	@Column(name = "NAME", nullable = false, length = 10)
	public String getName() {
		return this.name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	@Column(name = "[DESC]", nullable = false)
	public String getDesc() {
		return this.desc;
	}
 
	public void setDesc(String desc) {
		this.desc = desc;
	}
 
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	public Set<Incheiere> getIncheieri() {
		return this.incheieri;
	}
 
	public void setIncheieri(Set<Incheiere> incheieri) {
		this.incheieri = incheieri;
	}
 
}
