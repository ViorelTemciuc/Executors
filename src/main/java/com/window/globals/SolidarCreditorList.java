package com.window.globals;

import java.util.ArrayList;
import java.util.List;

import com.entities.Persons;

public class SolidarCreditorList extends AbstractCDClass {
	private volatile static SolidarCreditorList uniqueInstance;
	List<Persons> solCreditor;
	private SolidarCreditorList(){
		this.solCreditor=new ArrayList<Persons>();
	}
    
	public static SolidarCreditorList getInstance(){
		if(uniqueInstance==null){
			synchronized (SolidarCreditorList.class) {
				if(uniqueInstance==null){
					uniqueInstance=new SolidarCreditorList();
				}
			}
		}
		return uniqueInstance;
	}

	public List<Persons> getTor() {
		return solCreditor;
	}

	public void addTor(Persons list) {
		this.solCreditor.add(list);
	}
	
	public void editTor(Persons p,int index) {
		
		solCreditor.set(index, p);		
	
}
	public void deleteTor(Persons p) {
		
		int i=solCreditor.indexOf(p);
		solCreditor.remove(i);		
	
	}
}
