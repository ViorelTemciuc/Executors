package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable{

	@Id
	@Column(name = "username", unique = true, 
		nullable = false, length = 45)
	private String username;
	@Column(name = "password", 
			nullable = false, length = 60)
	private String password;
	@Column(name = "first_name", 
			nullable = false, length = 60)
	private String first_name;
	@Column(name = "last_name", 
			nullable = false, length = 60)
	private String last_name;
	@Column(name = "email", 
			nullable = false, length = 60)
	private String email;
	@Column(name = "enabled", 
			nullable = false, length = 60)
	private boolean enabled;
	@Column(name = "role", 
			nullable = false, length = 60)
	private String role;
	
 
	
 
	public User(){}
	
 
	
	public User(String username, String password, String first_name,
			String last_name, String email, boolean enabled, String role) {
		super();
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.enabled = enabled;
		this.role = role;
	}



	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getUsername() {
		return this.username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
 
	@Column(name = "password", 
		nullable = false, length = 60)
	public String getPassword() {
		return this.password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
 
	public boolean isEnabled() {
		return this.enabled;
	}
 
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
 
}
