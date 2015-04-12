package com.window.globals;

import java.util.ArrayList;
import java.util.List;

import com.entities.Persons;

public class SolidarDebtorList extends AbstractCDClass{
	private volatile static SolidarDebtorList uniqueInstance;
	List<Persons> solDebtor;
	private SolidarDebtorList(){
		this.solDebtor=new ArrayList<Persons>();
	}
    
	public static SolidarDebtorList getInstance(){
		if(uniqueInstance==null){
			synchronized (SolidarDebtorList.class) {
				if(uniqueInstance==null){
					uniqueInstance=new SolidarDebtorList();
				}
			}
		}
		return uniqueInstance;
	}

	public List<Persons> getTor() {
		return solDebtor;
	}

	public void addTor(Persons list) {
		this.solDebtor.add(list);
	}
	
	public void editTor(Persons p,int index) {
		
		solDebtor.set(index, p);		
	
}
	public void deleteTor(Persons p) {
		
		int i=solDebtor.indexOf(p);
		solDebtor.remove(i);		
	
	}
}
