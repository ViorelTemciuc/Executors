package com.window.globals;

import java.util.List;

import com.entities.Persons;

public abstract class AbstractCDClass {
	
	public abstract List<Persons> getTor() ;
	public abstract void addTor(Persons p) ;
	public abstract void editTor(Persons p,int index);
	public abstract void deleteTor(Persons p);

}
