package com.entities;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="positions",uniqueConstraints={@UniqueConstraint(columnNames="name")})

public class Positions implements Serializable {
	
	private Integer id_pos;
	private String name;
	private Set<players> players=new HashSet<players>(0);
	public Positions() {
		
	}
	public Positions(String name, Set<com.entities.players> players) {
		
		this.name = name;
		this.players = players;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="id_pos")
	public Integer getId_pos() {
		return id_pos;
	}
	
	public void setId_pos(Integer id_pos) {
		this.id_pos = id_pos;
	}
	
	@Column(name="name", unique=true, nullable=false, length=200 )
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="position")
	public Set<players> getPlayers() {
	return players;
	}
	public void setPlayers(Set<players> players) {
		this.players = players;
	}

	

}
