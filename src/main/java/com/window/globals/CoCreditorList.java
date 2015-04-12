package com.window.globals;

import java.util.ArrayList;
import java.util.List;

import com.entities.Persons;

public class CoCreditorList extends AbstractCDClass{
	
	private volatile static CoCreditorList uniqueInstance;
	List<Persons> coCreditor;
	private CoCreditorList(){
		this.coCreditor=new ArrayList<Persons>();
	}
    
	public static CoCreditorList getInstance(){
		if(uniqueInstance==null){
			synchronized (CoCreditorList.class) {
				if(uniqueInstance==null){
					uniqueInstance=new CoCreditorList();
				}
			}
		}
		return uniqueInstance;
	}

	public List<Persons> getTor() {
		return coCreditor;
	}

	public void addTor(Persons p) {
		this.coCreditor.add(p);
	}
	public void editTor(Persons p,int index) {
		
			coCreditor.set(index, p);
		
	}
	
public void deleteTor(Persons p) {
		
		int i=coCreditor.indexOf(p);
		coCreditor.remove(i);		
	
	}

}
