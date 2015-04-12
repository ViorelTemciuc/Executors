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

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="players",uniqueConstraints=@UniqueConstraint(columnNames="name"))
public class players {
	
	private Integer id_player;
	private String name;
    private Positions position;
    
  
	private List<SchemaStruct> schemastruct=new LinkedList<SchemaStruct>();
	public players() {
		
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="id_player",nullable=false)
	public Integer getId_player() {
		return id_player;
	}
	
	public void setId_player(Integer id_player) {
		this.id_player = id_player;
	}
	
	@Column(name="name", nullable=false,length=200)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.player")
	public List<SchemaStruct> getSchemastruct() {
		return schemastruct;
	}
	public void setSchemastruct(List<SchemaStruct> schemastruct) {
		this.schemastruct = schemastruct;
	}
	  @ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "id_pos", nullable = false)
		public Positions getPosition() {
			return position;
		}

		public void setPosition(Positions position) {
			this.position = position;
		}
}
