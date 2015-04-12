package com.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="fschema")
public class Schemas {
	
	private Integer id_schema;
	private String name;
	private List<SchemaStruct> schemastruct=new LinkedList<SchemaStruct>();
	public Schemas() {
		
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_schema", unique = true, nullable = false)
	public Integer getId_schema() {
		return id_schema;
	}
	public void setId_schema(Integer id_schema) {
		this.id_schema = id_schema;
	}
	@Column(name = "name",  nullable = false, length = 10)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.schema", cascade=CascadeType.ALL)
	public List<SchemaStruct> getSchemastruct() {
		return this.schemastruct;
	}
	public void setSchemastruct(List<SchemaStruct> schemastruct) {
		this.schemastruct = schemastruct;
	}
	
	
	
	
}
